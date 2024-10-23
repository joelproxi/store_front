package org.proxidev.order_ms.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/api/v1/inventories/{productId}")
    InventoryDTO getInventoryById(@PathVariable Long productId);

    @PutMapping("/api/v1/inventories/{productId}")
    InventoryDTO updateQuantity(@PathVariable Long productId, @RequestBody Integer quantity);
}
