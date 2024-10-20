package org.proxidev.order_ms.order;


import org.proxidev.order_ms.payload.PagedResponse;

public interface OrderService {
    PagedResponse<OrderResponse> getAllOrders(Integer page, Integer pageSize);
    OrderResponse getOrderById(Long id);
    OrderResponse createOrder(OrderRequest orderRequest);
    OrderResponse updateOrder(OrderRequest orderRequest, String id);
    OrderResponse deleteOrder(String id);
}
