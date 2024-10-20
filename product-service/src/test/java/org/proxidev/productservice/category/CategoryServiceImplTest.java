package org.proxidev.productservice.category;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class CategoryServiceImplTest {
    @InjectMocks
    private CategoryServiceImpl categoryService;
    @Mock
    private CategoryMapper categoryMapper;
    @Mock
    private CategoryRepository categoryRepository;
    private Category category;
    private CategoryRequest categoryRequest;
    private CategoryResponse categoryResponse;
    private Category existingCategory;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        category = new Category(1L, "iphone");
        categoryRequest = new CategoryRequest("iphone");
        categoryResponse = new CategoryResponse(1L, "iphone");
        existingCategory = new Category(1L, "iphone");
    }

    @Test
    public void test_it_should_return_category_list(){
        // Mock calls
        when(categoryRepository.findAll()).thenReturn(Collections.singletonList(category));
        when(categoryMapper.mapToDto(category)).thenReturn(categoryResponse);

        // Act
        List<CategoryResponse> categoryResponseList = categoryService.getAllCategories();

        //Assert
        assertNotNull(categoryResponseList);
        assertEquals(categoryResponseList.size(), 1);


        verify( categoryRepository, times(1)).findAll();

    }

    @Test
    public void test_it_should_create_category_with_valid_data(){
        when(categoryMapper.mapToEntity(categoryRequest)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);
        when(categoryMapper.mapToDto(category)).thenReturn(categoryResponse);

        // Act
        CategoryResponse result = categoryService.createCategory(categoryRequest);

        //assert
        assertNotNull(result);
        assertEquals(categoryRequest.name(), result.name());
        verify(categoryRepository, times(1)).save(category);

    }

    @Test
    public void test_it_should_update_category_with_valid_data(){
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(categoryMapper.mapToEntity(categoryRequest)).thenReturn(category);
        when(categoryRepository.save(category)).thenReturn(category);
        when(categoryMapper.mapToDto(category)).thenReturn(categoryResponse);

        // Act
        CategoryResponse result = categoryService.updateCategory(1L, categoryRequest);

        // Assert
        assertNotNull(result);
        assertEquals(categoryRequest.name(), result.name());
        assertEquals(existingCategory.getId(), result.id());

        verify(categoryRepository, times(1)).save(category);
        verify(categoryRepository, times(1)).findById(1L);
        verify(categoryMapper, times(1)).mapToEntity(categoryRequest);
        verify(categoryMapper, times(1)).mapToDto(category);

    }


    @Test
    public void test_it_should_find_category_with_id_and_return_CategoryResponse(){
        when(categoryRepository.findById(1L)).thenReturn(Optional.of(category));
        when(categoryMapper.mapToDto(category)).thenReturn(categoryResponse);

        // Act
        CategoryResponse result = categoryService.getCategoryDetail(1L);

        //Assert
        assertNotNull(result);
        assertEquals(categoryResponse.name(), result.name());
        verify(categoryRepository, times(1)).findById(1L);
        verify(categoryMapper, times(1)).mapToDto(category);
    }


}