package org.proxidev.invenrotyservice.inventory;

import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("inventories")
public class InventoryController {
    private static final Logger log = org.slf4j.LoggerFactory.getLogger(InventoryController.class);
    private final InventoryService inventoryService;

    public InventoryController(InventoryService inventoryService) {
        this.inventoryService = inventoryService;
    }

    @GetMapping
    ResponseEntity<List<InventoryDTO>> getAllInventories() {
        return ResponseEntity.ok(inventoryService.getAllInventories());
    }

    @PostMapping
    ResponseEntity<Boolean> createInventory(@RequestBody InventoryDTO dto) {
        var response = inventoryService.createInventory(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping("/{productId}")
    ResponseEntity<InventoryDTO> getInventoryByProductId(@PathVariable Long productId) {
        var response = inventoryService.getInventoryByProductId(productId);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PutMapping("/{productId}")
    ResponseEntity<InventoryDTO> updateInventoryQuantity(@PathVariable Long productId, @RequestBody Integer quantity) {
        log.info(String.format("%d <-----> %d", productId, quantity));
        var response = inventoryService.updateInventoryQuantity(productId, quantity);
        log.info(String.format(" <-----> %s", response));

        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
