package org.proxidev.productservice.inventory;

import org.proxidev.productservice.product.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryClient inventoryClient;

    public InventoryService(InventoryClient inventoryClient) {
        this.inventoryClient = inventoryClient;
    }

    public List<InventoryDTO> getAllInventories() {
        ResponseEntity<List<InventoryDTO>> response = inventoryClient.getAllInventories();
        return response.getBody();
    }

    public boolean createInventory(Product product) {
        InventoryDTO inventoryDTO = InventoryDTO.builder()
                .productId(product.getId())
                .quantity(product.getQuantity())
                .build();
        ResponseEntity<Void> resp = inventoryClient.createInventory(inventoryDTO);
        return resp.getStatusCode().is2xxSuccessful();
    }
}
