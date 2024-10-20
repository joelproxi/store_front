package org.proxidev.order_ms.order;

public class OrderProductMapper {
    
    public static OrderProductResponse mapToDto(OrderProduct entity){
        if(entity == null){ 
            throw new NullPointerException(" entity is null");
        }

        return OrderProductResponse.builder()
            .id(entity.getId())
            .productId(entity.getProductId())
//                .productName(entity.getProduct().getName())
            .price(entity.getPrice())
            .quantity(entity.getQuantity())
        .build();
    }

    public static OrderProduct mapToEntity(OrderProductRequest dto, Order order){
        if(dto == null){ 
            throw new NullPointerException(" dto is null");
        }
        return OrderProduct.builder()
        .order(order)
        .productId(dto.getProductId())
        .quantity(dto.getQuantity())
        .price(dto.getPrice())
        .build();
    }
}
