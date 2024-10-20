package org.proxidev.invenrotyservice.inventory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class InventoryServiceImpl implements InventoryService {
    private final InventoryRepository inventoryRepository;
    private final InventoryMapper mapper;

    @Override
    public boolean createInventory(InventoryDTO dto) {
        Inventory inventory = mapper.mapToInventory(dto);
        Inventory savedInventory = inventoryRepository.save(inventory);
        return !Objects.equals(savedInventory,null);
    }

    @Override
    public InventoryDTO getInventoryByProductId(Long productId) {
        Inventory inventory = inventoryRepository.findByProductId(productId).orElseThrow(
                () -> new RuntimeException("Product with this id not found")
        );
        return mapper.mapToDTO(inventory);
    }

    @Override
    public InventoryDTO updateInventoryQuantity(Long productId, Integer quantity) {
        Inventory inventory = inventoryRepository.findByProductId(productId).orElseThrow(
                () -> new RuntimeException("Product with this id not found")
        );
        inventory.setQuantity(quantity);
        return mapper.mapToDTO(inventoryRepository.save(inventory));
    }


}
