package org.proxidev.invenrotyservice.inventory;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("inventories")
@Slf4j
public class InventoryController {
    private final InventoryService inventoryService;

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
