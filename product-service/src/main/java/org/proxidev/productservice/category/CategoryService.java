package org.proxidev.productservice.category;

import java.util.List;



public interface CategoryService {
    List<CategoryResponse> getAllCategories();

    CategoryResponse getCategoryDetail(Long id);

    CategoryResponse createCategory(CategoryRequest dto);

    CategoryResponse updateCategory(Long id, CategoryRequest dto);

    void deleteCategory(Long id);
}
