package org.proxidev.order_ms.inventory;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient(url = "http://localhost:9501/api/v1/inventories", name = "inventory-service")
public interface InventoryClient {

    @GetMapping("/{productId}")
    InventoryDTO getInventoryById(@PathVariable Long productId);

    @PutMapping("/{productId}")
    InventoryDTO updateQuantity(@PathVariable Long productId, @RequestBody Integer quantity);
}
