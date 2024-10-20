package org.proxidev.order_ms.order;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderProductRequest {
    private Long productId;
    private Integer quantity;
    private Double price;
}
