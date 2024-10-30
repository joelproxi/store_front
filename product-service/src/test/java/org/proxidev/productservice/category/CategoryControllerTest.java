package org.proxidev.productservice.category;

import com.fasterxml.jackson.databind.ObjectMapper;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;


import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
@Transactional
class CategoryControllerTest {
    @Autowired
    private MockMvc mockMvc;
    @Autowired
    private ObjectMapper jacksonObjectMapper;
    private CategoryRequest categoryRequest;
    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private CategoryMapper categoryMapper;

    @BeforeEach
    void setUp() {
        categoryRequest = new CategoryRequest("Bière");
    }

    @Test
    public void test_it_should_create_category() throws Exception {


        mockMvc.perform(post("/categories")
                .contentType(MediaType.APPLICATION_JSON)
                .content(jacksonObjectMapper.writeValueAsString(categoryRequest)))
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.name").value(categoryRequest.name()));

    }

    @Test
    public void test_it_should_update_category() throws Exception {

        Long categoryId = categoryRepository.save(categoryMapper.mapToEntity(categoryRequest)).getId();
        CategoryRequest uc = new CategoryRequest("jus");

        mockMvc.perform(put("/categories/{id}",  categoryId)
                .contentType(MediaType.APPLICATION_JSON)
                .content(jacksonObjectMapper.writeValueAsString(uc)))
                .andExpect(status().isOk());


    }


    @Test
    public void test_it_should_delete_category() throws Exception {
        Long categoryId = categoryRepository.save(categoryMapper.mapToEntity(categoryRequest)).getId();

        mockMvc.perform(delete("/categories/{id}", categoryId)
        .contentType(MediaType.APPLICATION_JSON)).andExpect(status().isNoContent());
    }

    @Test
    public void test_it_should_return_all_categories() throws Exception {
        mockMvc.perform(get("/categories")).andExpect(status().isOk());
    }
}