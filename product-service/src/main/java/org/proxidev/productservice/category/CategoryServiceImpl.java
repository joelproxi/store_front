package org.proxidev.productservice.category;



import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.proxidev.productservice.handleException.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

import static org.proxidev.productservice.utils.AppConstants.CATEGORY;
import static org.proxidev.productservice.utils.AppConstants.ID;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements CategoryService{
    private final CategoryRepository categoryRepository;
    private final CategoryMapper mapper;

    @Override
    public List<CategoryResponse> getAllCategories() {
       List<Category> categories = categoryRepository.findAll();
       return categories.stream().map(mapper::mapToDto).toList();
    }

    @Override
    public CategoryResponse getCategoryDetail(Long id) {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("Not found"));
        return mapper.mapToDto(category);
    }

    @Override
    public CategoryResponse createCategory(CategoryRequest dto) {
        Category category = mapper.mapToEntity(dto);
        Category savedCat = categoryRepository.save(category);
       return mapper.mapToDto(savedCat);
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryRequest dto) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(CATEGORY, ID, id));
        Category category = mapper.mapToEntity(dto);
        category.setId(existingCategory.getId());
        return mapper.mapToDto(categoryRepository.save(category));
    }

    @Override
    public void deleteCategory(Long id) {
        Category existingCategory = categoryRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException(CATEGORY, ID, id));
        categoryRepository.delete(existingCategory);
    }
    
}
