package org.proxidev.invenrotyservice.inventory;

import java.util.List;

public interface InventoryService {
    boolean createInventory(InventoryDTO dto);
    InventoryDTO getInventoryByProductId(Long productId);
    InventoryDTO updateInventoryQuantity(Long productId, Integer quantity);
    List<InventoryDTO> getAllInventories();
}
