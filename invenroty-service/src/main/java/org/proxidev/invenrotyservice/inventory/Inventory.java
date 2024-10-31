package org.proxidev.invenrotyservice.inventory;

import jakarta.persistence.*;

@Entity
@Table(name = "inventories")
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    @Column(nullable = false)
    private Long productId;
    private Integer quantity;

    public Inventory(Long id, Long productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public Inventory() {
    }

    public static InventoryBuilder builder() {
        return new InventoryBuilder();
    }

    public Long getId() {
        return this.id;
    }

    public Long getProductId() {
        return this.productId;
    }

    public Integer getQuantity() {
        return this.quantity;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setProductId(Long productId) {
        this.productId = productId;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public static class InventoryBuilder {
        private Long id;
        private Long productId;
        private Integer quantity;

        InventoryBuilder() {
        }

        public InventoryBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public InventoryBuilder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public InventoryBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public Inventory build() {
            return new Inventory(this.id, this.productId, this.quantity);
        }

        public String toString() {
            return "Inventory.InventoryBuilder(id=" + this.id + ", productId=" + this.productId + ", quantity=" + this.quantity + ")";
        }
    }
}
