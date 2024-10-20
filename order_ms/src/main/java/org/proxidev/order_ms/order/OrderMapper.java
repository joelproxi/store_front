package org.proxidev.order_ms.order;


import java.util.Set;

public interface OrderMapper {
    Order mapToEntity(OrderRequest dto, Set<OrderProduct> orderProducts);

    OrderResponse mapToDto(Order entity);
}
