package org.proxidev.order_ms.inventory;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class InventoryDTO {
    private Long id;
    private Long productId;
    private Integer quantity;
}
