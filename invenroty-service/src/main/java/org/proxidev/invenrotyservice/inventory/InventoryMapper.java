package org.proxidev.invenrotyservice.inventory;

import org.springframework.stereotype.Service;

@Service
public class InventoryMapper {

    public InventoryDTO mapToDTO(Inventory inventory) {
        return InventoryDTO.builder()
                .id(inventory.getId())
                .productId(inventory.getProductId())
                .quantity(inventory.getQuantity())
                .build();
    }

    public Inventory mapToInventory(InventoryDTO inventoryDTO) {
        return Inventory.builder()
                .id(inventoryDTO.getId())
                .productId(inventoryDTO.getProductId())
                .quantity(inventoryDTO.getQuantity())
                .build();
    }
}
