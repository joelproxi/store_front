package org.proxidev.productservice.inventory;

import org.proxidev.productservice.product.Product;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class InventoryService {
    private final RestTemplate restTemplate;

    public InventoryService(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    public boolean createInventory(Product product) {
        InventoryDTO inventoryDTO = InventoryDTO.builder()
                .productId(product.getId())
                .quantity(product.getQuantity())
                .build();
        ResponseEntity<Void> resp = restTemplate.postForEntity(
                "http://inventory-service" + "/api/v1/inventories",
                inventoryDTO, Void.class);
        return resp.getStatusCode().is2xxSuccessful();
    }
}
