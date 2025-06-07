package org.proxidev.order_ms.order;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import org.proxidev.order_ms.inventory.InventoryClient;
import org.proxidev.order_ms.inventory.InventoryDTO;
import org.proxidev.order_ms.payload.PagedResponse;
import org.slf4j.Logger;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class OrderServiceImpl implements OrderService {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(OrderServiceImpl.class);
    private final OrderRepository orderRepository;
    private final OrderMapper orderMapper;
    private final InventoryClient inventoryClient;
    private final OrderProductRepository orderProductRepository;

    public OrderServiceImpl(OrderRepository orderRepository, OrderMapper orderMapper, InventoryClient inventoryClient, OrderProductRepository orderProductRepository) {
        this.orderRepository = orderRepository;
        this.orderMapper = orderMapper;
        this.inventoryClient = inventoryClient;
        this.orderProductRepository = orderProductRepository;
    }


    @Override
    public PagedResponse<OrderResponse> getAllOrders(Integer page, Integer pageSize) {
        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(Sort.Direction.DESC, "firstName"));
        Page<Order> orderPage = orderRepository.findAll(pageable);
        return PagedResponse.<OrderResponse>builder()
                .content(orderPage.getContent().stream().map(orderMapper::mapToDto).toList())
                .last(orderPage.isLast())
                .first(orderPage.isFirst())
                .totalPages(orderPage.getTotalPages())
                .totalElements(orderPage.getTotalElements())
                .number(orderPage.getNumber())
                .size(orderPage.getSize())
                .build();
    }

    @Override
    public OrderResponse getOrderById(Long id) {
        Order order = orderRepository.findById(String.valueOf(id))
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
        return orderMapper.mapToDto(order);
    }

    @Override
    public OrderResponse createOrder(OrderRequest entity) {
        if (entity == null) {
            throw new IllegalArgumentException("OrderRequest is null");
        }
        if (entity.getOrderProducts().isEmpty()) {
            throw new IllegalArgumentException("OrderProducts is empty");
        }

        Set<OrderProduct> orderProducts = entity.getOrderProducts().stream().map(
                orderProductRequest -> {
//                    Product product = productRepository.findById(orderProductRequest.getProductId())
//                            .orElseThrow(() -> new EntityNotFoundException("Product not found: "+ orderProductRequest.getProductId()));
                    InventoryDTO product = inventoryClient.getInventoryById(orderProductRequest.getProductId());
                    if (product == null) {
                        throw new EntityNotFoundException("Product not found: " + orderProductRequest.getProductId());
                    }
                    if (product.getQuantity() < orderProductRequest.getQuantity()) {
                        throw new IllegalArgumentException("OrderProducts contains insufficient quantity");
                    }

                    int newQuantity = product.getQuantity() - orderProductRequest.getQuantity();
                    log.info(String.valueOf(newQuantity));
//                    productRepository.save(product);
                    var apiRes = inventoryClient.updateQuantity(product.getProductId(), newQuantity);
                    log.info(String.valueOf(apiRes));
                    if (apiRes == null) {
                        throw new IllegalArgumentException("OrderProducts contains insufficient quantity");
                    }

                    return OrderProduct.builder()
                            .quantity(orderProductRequest.getQuantity())
                            .price(orderProductRequest.getPrice())
                            .productId(product.getProductId())
                            .build();
                }
        ).collect(Collectors.toSet());

        Order order = Order.builder()
                .firstName(entity.getFirstName())
                .lastName(entity.getLastName())
                .email(entity.getEmail())
                .address(entity.getAddress())
                .orderProducts(orderProducts)
                .build();

        orderProducts.forEach(orderProduct -> orderProduct.setOrder(order));

        Order savedOrder = orderRepository.save(order);
        return orderMapper.mapToDto(savedOrder);

    }

    @Override
    public OrderResponse updateOrder(OrderRequest orderRequest, String id) {
        return null;
    }

    @Override
    public OrderResponse deleteOrder(String id) {
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Order not found with id: " + id));
        
        // Restore inventory quantities before deleting the order
        order.getOrderProducts().forEach(orderProduct -> {
            InventoryDTO inventory = inventoryClient.getInventoryById(orderProduct.getProductId());
            if (inventory != null) {
                int newQuantity = inventory.getQuantity() + orderProduct.getQuantity();
                inventoryClient.updateQuantity(orderProduct.getProductId(), newQuantity);
            }
        });

        orderRepository.delete(order);
        return orderMapper.mapToDto(order);
    }
}
