package org.proxidev.productservice.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "inventory-service", path = "/api/v1/inventories")
public interface InventoryClient {
    
    @GetMapping
    ResponseEntity<List<InventoryDTO>> getAllInventories();

    @PostMapping
    ResponseEntity<Void> createInventory(@RequestBody InventoryDTO inventoryDTO);
} 