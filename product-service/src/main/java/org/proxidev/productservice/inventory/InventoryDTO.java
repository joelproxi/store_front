package org.proxidev.productservice.inventory;

import jakarta.persistence.Column;

import java.util.Objects;

public class InventoryDTO {
    private Long id;
    @Column(nullable = false)
    private Long productId;
    private Integer quantity;

    public InventoryDTO(Long id, Long productId, Integer quantity) {
        this.id = id;
        this.productId = productId;
        this.quantity = quantity;
    }

    public static InventoryDTOBuilder builder() {
        return new InventoryDTOBuilder();
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

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof InventoryDTO other)) return false;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (!Objects.equals(this$id, other$id)) return false;
        final Object this$productId = this.getProductId();
        final Object other$productId = other.getProductId();
        if (!Objects.equals(this$productId, other$productId)) return false;
        final Object this$quantity = this.getQuantity();
        final Object other$quantity = other.getQuantity();
        return Objects.equals(this$quantity, other$quantity);
    }

    protected boolean canEqual(final Object other) {
        return other instanceof InventoryDTO;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $productId = this.getProductId();
        result = result * PRIME + ($productId == null ? 43 : $productId.hashCode());
        final Object $quantity = this.getQuantity();
        result = result * PRIME + ($quantity == null ? 43 : $quantity.hashCode());
        return result;
    }

    public String toString() {
        return "InventoryDTO(id=" + this.getId() + ", productId=" + this.getProductId() + ", quantity=" + this.getQuantity() + ")";
    }

    public static class InventoryDTOBuilder {
        private Long id;
        private Long productId;
        private Integer quantity;

        InventoryDTOBuilder() {
        }

        public InventoryDTOBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public InventoryDTOBuilder productId(Long productId) {
            this.productId = productId;
            return this;
        }

        public InventoryDTOBuilder quantity(Integer quantity) {
            this.quantity = quantity;
            return this;
        }

        public InventoryDTO build() {
            return new InventoryDTO(this.id, this.productId, this.quantity);
        }

        public String toString() {
            return "InventoryDTO.InventoryDTOBuilder(id=" + this.id + ", productId=" + this.productId + ", quantity=" + this.quantity + ")";
        }
    }
}

