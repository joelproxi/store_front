package org.proxidev.invenrotyservice.inventory;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class InventoryDTO {
    private Long id;
    @Column(nullable = false)
    private Long productId;
    private Integer quantity;
}

