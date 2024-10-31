package org.proxidev.productservice.product;


public class ProductRequest {
    private String name;
    private String description;
    private Double price;
    private Integer quantity;
    private Long categoryId;

    public ProductRequest(String name, String description, Double price, Integer quantity, Long categoryId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.categoryId = categoryId;
    }

    public ProductRequest() {
    }

    public static ProductRequestBuilder builder() {
        return new ProductRequestBuilder();
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

    public Long getCategoryId() {
        return this.categoryId;
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

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public static class ProductRequestBuilder {
        private String name;
        private String description;
        private Double price;
        private Integer quantity;
        private Long categoryId;

        ProductRequestBuilder() {
        }

        public ProductRequestBuilder name(String name) {
            this.name = name;
            return this;
        }

        public ProductRequestBuilder description(String description) {
            this.description = description;
            return this;
        }

        public ProductRequestBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public ProductRequestBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public ProductRequestBuilder categoryId(Long categoryId) {
            this.categoryId = categoryId;
            return this;
        }

        public ProductRequest build() {
            return new ProductRequest(this.name, this.description, this.price, this.quantity, this.categoryId);
        }

        public String toString() {
            return "ProductRequest.ProductRequestBuilder(name=" + this.name + ", description=" + this.description + ", price=" + this.price + ", quantity=" + this.quantity + ", categoryId=" + this.categoryId + ")";
        }
    }
}
