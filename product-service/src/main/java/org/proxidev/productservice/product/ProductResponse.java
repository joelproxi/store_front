package org.proxidev.productservice.product;

import org.proxidev.productservice.category.CategoryResponse;

public class ProductResponse {
    private Long id;
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private CategoryResponse category;

    public ProductResponse(Long id, String name, String description, Double price, Integer quantity, CategoryResponse category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.category = category;
    }

    public ProductResponse() {
    }

    public static ProductResponseBuilder builder() {
        return new ProductResponseBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getDescription() {
        return this.description;
    }

    public Double getPrice() {
        return this.price;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public CategoryResponse getCategory() {
        return this.category;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setCategory(CategoryResponse category) {
        this.category = category;
    }

    public static class ProductResponseBuilder {
        private Long id;
        private String name;
        private String description;
        private Double price;
        private Integer quantity;
        private CategoryResponse category;

        ProductResponseBuilder() {
        }

        public ProductResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public ProductResponseBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductResponseBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductResponseBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public ProductResponseBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductResponseBuilder category(CategoryResponse category) {
            this.category = category;
            return this;
        }

        public ProductResponse build() {
            return new ProductResponse(this.id, this.name, this.description, this.price, this.quantity, this.category);
        }

        public String toString() {
            return "ProductResponse.ProductResponseBuilder(id=" + this.id + ", name=" + this.name + ", description=" + this.description + ", price=" + this.price + ", quantity=" + this.quantity + ", category=" + this.category + ")";
        }
    }
}
