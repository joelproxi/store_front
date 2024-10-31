package org.proxidev.order_ms.order;

import jakarta.persistence.*;

@Entity
@Table(name = "order_products")
public class OrderProduct {
    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private Long productId;
    //    @Transient
//    private Product product;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id", nullable = false, referencedColumnName = "id")
    private Order order;

    private Integer quantity;
    private Double price;

    public OrderProduct(Long id, Long productId, Order order, Integer quantity, Double price) {
        this.id = id;
        this.productId = productId;
        this.order = order;
        this.quantity = quantity;
        this.price = price;
    }

    public OrderProduct() {
    }

    public static OrderProductBuilder builder() {
        return new OrderProductBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Long getProductId() {
        return this.productId;
    }

    public Order getOrder() {
        return this.order;
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

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public static class OrderProductBuilder {
        private Long id;
        private Long productId;
        private Order order;
        private Integer quantity;
        private Double price;

        OrderProductBuilder() {
        }

        public OrderProductBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public OrderProductBuilder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public OrderProductBuilder order(Order order) {
            this.order = order;
            return this;
        }

        public OrderProductBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public OrderProductBuilder price(Double price) {
            this.price = price;
            return this;
        }

        public OrderProduct build() {
            return new OrderProduct(this.id, this.productId, this.order, this.quantity, this.price);
        }

        public String toString() {
            return "OrderProduct.OrderProductBuilder(id=" + this.id + ", productId=" + this.productId + ", order=" + this.order + ", quantity=" + this.quantity + ", price=" + this.price + ")";
        }
    }
}
