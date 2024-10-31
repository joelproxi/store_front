package org.proxidev.productservice.product;

import org.proxidev.productservice.payload.PagedResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import static org.proxidev.productservice.utils.AppConstants.PAGE_NUMBER;
import static org.proxidev.productservice.utils.AppConstants.PAGE_SIZE;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<PagedResponse<ProductResponse>> getAllProducts(
            @RequestParam(name = "page", required = false, defaultValue = PAGE_NUMBER) int page,
            @RequestParam(name = "size", required = false, defaultValue = PAGE_SIZE) int size
    ) {
        return ResponseEntity.ok(productService.getAllProducts(page, size));
    }


    @PostMapping
    public ResponseEntity<ProductResponse> createProduct(@RequestBody ProductRequest request) {
        return ResponseEntity.status(HttpStatus.CREATED).body(productService.createProduct(request));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductResponse> getProduct(@PathVariable long id) {
        return ResponseEntity.ok(productService.getProduct(id));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<PagedResponse<ProductResponse>> getProductByCategory(
            @PathVariable(value = "id") int id,
            @RequestParam(name = "page", required = false, defaultValue = PAGE_NUMBER) int page,
            @RequestParam(name = "size", required = false, defaultValue = PAGE_SIZE) int size) {
        return ResponseEntity.ok(productService.getProductsByCategory(id, page, size));
    }

}
