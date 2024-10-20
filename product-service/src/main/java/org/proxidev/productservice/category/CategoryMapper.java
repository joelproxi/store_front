package org.proxidev.productservice.category;


import org.springframework.stereotype.Service;


@Service
public class CategoryMapper {
    public CategoryResponse mapToDto(Category entity){
        if(entity == null){
            throw new NullPointerException("Entity not found");
        }
        return new CategoryResponse(entity.getId(), entity.getName());
    
    }

    public Category mapToEntity(CategoryRequest dto){
        if(dto == null){
            throw new NullPointerException("dto not found");
        }
        return  Category.builder().name(dto.name()).build();
    }
}
