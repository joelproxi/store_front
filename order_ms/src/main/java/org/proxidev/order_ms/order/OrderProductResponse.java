package org.proxidev.order_ms.order;

public class OrderProductResponse {
    private Long id;
    private Long productId;
    private String productName;
    private Integer quantity;
    private Double price;

    public OrderProductResponse(Long id, Long productId, String productName, Integer quantity, Double price) {
        this.id = id;
        this.productId = productId;
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderProductResponse() {
    }

    public static OrderProductResponseBuilder builder() {
        return new OrderProductResponseBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Long getProductId() {
        return this.productId;
    }

    public String getProductName() {
        return this.productName;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public Double getPrice() {
        return this.price;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OrderProductResponse)) return false;
        final OrderProductResponse other = (OrderProductResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$productId = this.getProductId();
        final Object other$productId = other.getProductId();
        if (this$productId == null ? other$productId != null : !this$productId.equals(other$productId)) return false;
        final Object this$productName = this.getProductName();
        final Object other$productName = other.getProductName();
        if (this$productName == null ? other$productName != null : !this$productName.equals(other$productName))
            return false;
        final Object this$quantity = this.getQuantity();
        final Object other$quantity = other.getQuantity();
        if (this$quantity == null ? other$quantity != null : !this$quantity.equals(other$quantity)) return false;
        final Object this$price = this.getPrice();
        final Object other$price = other.getPrice();
        if (this$price == null ? other$price != null : !this$price.equals(other$price)) return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderProductResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final Object $productName = this.getProductName();
        result = result * PRIME + ($productName == null ? 43 : $productName.hashCode());
        final Object $quantity = this.getQuantity();
        result = result * PRIME + ($quantity == null ? 43 : $quantity.hashCode());
        final Object $price = this.getPrice();
        result = result * PRIME + ($price == null ? 43 : $price.hashCode());
        return result;
    }

    public String toString() {
        return "OrderProductResponse(id=" + this.getId() + ", productId=" + this.getProductId() + ", productName=" + this.getProductName() + ", quantity=" + this.getQuantity() + ", price=" + this.getPrice() + ")";
    }

    public static class OrderProductResponseBuilder {
        private Long id;
        private Long productId;
        private String productName;
        private Integer quantity;
        private Double price;

        OrderProductResponseBuilder() {
        }

        public OrderProductResponseBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public OrderProductResponseBuilder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public OrderProductResponseBuilder productName(String productName) {
            this.productName = productName;
            return this;
        }

        public OrderProductResponseBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderProductResponseBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public OrderProductResponse build() {
            return new OrderProductResponse(this.id, this.productId, this.productName, this.quantity, this.price);
        }

        public String toString() {
            return "OrderProductResponse.OrderProductResponseBuilder(id=" + this.id + ", productId=" + this.productId + ", productName=" + this.productName + ", quantity=" + this.quantity + ", price=" + this.price + ")";
        }
    }
}
