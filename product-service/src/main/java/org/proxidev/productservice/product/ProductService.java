package org.proxidev.productservice.product;


import org.proxidev.productservice.payload.PagedResponse;

public interface ProductService {
    
    PagedResponse<ProductResponse> getAllProducts(int page, int size);

    ProductResponse createProduct(ProductRequest dto);

    ProductResponse updateProduct(long id, ProductRequest dto);

    void productDelete(long id);

    ProductResponse getProduct(long id);

    PagedResponse<ProductResponse> getProductsByCategory(long id,int page, int size);
}
