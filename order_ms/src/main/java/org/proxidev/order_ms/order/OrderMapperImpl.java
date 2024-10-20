package org.proxidev.order_ms.order;

import java.util.Set;
import java.util.stream.Collectors;


import org.springframework.stereotype.Service;

@Service
public class OrderMapperImpl implements OrderMapper{

   

    @Override
    public OrderResponse mapToDto(Order entity) {

        Set<OrderProductResponse> orderProducts = entity.getOrderProducts().stream().map(
                OrderProductMapper::mapToDto
        ).collect(Collectors.toSet());

      return OrderResponse.builder()
      .id(entity.getId())
      .firstName(entity.getFirstName())
      .lastName(entity.getLastName())
      .email(entity.getEmail())
      .address(entity.getAddress())
      .orderProducts(orderProducts)
      .build();
    }



    @Override
    public Order mapToEntity(OrderRequest dto, Set<OrderProduct> orderProducts) {
        return Order.builder()
                .firstName(dto.getFirstName())
                .lastName(dto.getLastName())
                .email(dto.getEmail())
                .address(dto.getAddress())
                .orderProducts(orderProducts)
        .build();
    }
    
}
