package org.proxidev.order_ms.order;

import java.util.Set;

public class OrderResponse {
    private String id;
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private Set<OrderProductResponse> orderProducts;

    public OrderResponse(String id, String lastName, String firstName, String email, String address, Set<OrderProductResponse> orderProducts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.orderProducts = orderProducts;
    }

    public OrderResponse() {
    }

    public static OrderResponseBuilder builder() {
        return new OrderResponseBuilder();
    }

    public String getId() {
        return this.id;
    }

    public String getLastName() {
        return this.lastName;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public String getEmail() {
        return this.email;
    }

    public String getAddress() {
        return this.address;
    }

    public Set<OrderProductResponse> getOrderProducts() {
        return this.orderProducts;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setOrderProducts(Set<OrderProductResponse> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public boolean equals(final Object o) {
        if (o == this) return true;
        if (!(o instanceof OrderResponse)) return false;
        final OrderResponse other = (OrderResponse) o;
        if (!other.canEqual((Object) this)) return false;
        final Object this$id = this.getId();
        final Object other$id = other.getId();
        if (this$id == null ? other$id != null : !this$id.equals(other$id)) return false;
        final Object this$lastName = this.getLastName();
        final Object other$lastName = other.getLastName();
        if (this$lastName == null ? other$lastName != null : !this$lastName.equals(other$lastName)) return false;
        final Object this$firstName = this.getFirstName();
        final Object other$firstName = other.getFirstName();
        if (this$firstName == null ? other$firstName != null : !this$firstName.equals(other$firstName)) return false;
        final Object this$email = this.getEmail();
        final Object other$email = other.getEmail();
        if (this$email == null ? other$email != null : !this$email.equals(other$email)) return false;
        final Object this$address = this.getAddress();
        final Object other$address = other.getAddress();
        if (this$address == null ? other$address != null : !this$address.equals(other$address)) return false;
        final Object this$orderProducts = this.getOrderProducts();
        final Object other$orderProducts = other.getOrderProducts();
        if (this$orderProducts == null ? other$orderProducts != null : !this$orderProducts.equals(other$orderProducts))
            return false;
        return true;
    }

    protected boolean canEqual(final Object other) {
        return other instanceof OrderResponse;
    }

    public int hashCode() {
        final int PRIME = 59;
        int result = 1;
        final Object $id = this.getId();
        result = result * PRIME + ($id == null ? 43 : $id.hashCode());
        final Object $lastName = this.getLastName();
        result = result * PRIME + ($lastName == null ? 43 : $lastName.hashCode());
        final Object $firstName = this.getFirstName();
        result = result * PRIME + ($firstName == null ? 43 : $firstName.hashCode());
        final Object $email = this.getEmail();
        result = result * PRIME + ($email == null ? 43 : $email.hashCode());
        final Object $address = this.getAddress();
        result = result * PRIME + ($address == null ? 43 : $address.hashCode());
        final Object $orderProducts = this.getOrderProducts();
        result = result * PRIME + ($orderProducts == null ? 43 : $orderProducts.hashCode());
        return result;
    }

    public String toString() {
        return "OrderResponse(id=" + this.getId() + ", lastName=" + this.getLastName() + ", firstName=" + this.getFirstName() + ", email=" + this.getEmail() + ", address=" + this.getAddress() + ", orderProducts=" + this.getOrderProducts() + ")";
    }

    public static class OrderResponseBuilder {
        private String id;
        private String lastName;
        private String firstName;
        private String email;
        private String address;
        private Set<OrderProductResponse> orderProducts;

        OrderResponseBuilder() {
        }

        public OrderResponseBuilder id(String id) {
            this.id = id;
            return this;
        }

        public OrderResponseBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public OrderResponseBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public OrderResponseBuilder email(String email) {
            this.email = email;
            return this;
        }

        public OrderResponseBuilder address(String address) {
            this.address = address;
            return this;
        }

        public OrderResponseBuilder orderProducts(Set<OrderProductResponse> orderProducts) {
            this.orderProducts = orderProducts;
            return this;
        }

        public OrderResponse build() {
            return new OrderResponse(this.id, this.lastName, this.firstName, this.email, this.address, this.orderProducts);
        }

        public String toString() {
            return "OrderResponse.OrderResponseBuilder(id=" + this.id + ", lastName=" + this.lastName + ", firstName=" + this.firstName + ", email=" + this.email + ", address=" + this.address + ", orderProducts=" + this.orderProducts + ")";
        }
    }
}
