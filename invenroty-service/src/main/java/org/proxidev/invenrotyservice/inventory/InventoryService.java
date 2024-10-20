package org.proxidev.invenrotyservice.inventory;

public interface InventoryService {
    boolean createInventory(InventoryDTO dto);
    InventoryDTO getInventoryByProductId(Long productId);

    InventoryDTO updateInventoryQuantity(Long productId, Integer quantity);
}
