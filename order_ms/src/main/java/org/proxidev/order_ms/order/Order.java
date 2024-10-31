package org.proxidev.order_ms.order;


import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private Set<OrderProduct> orderProducts;

    public Order(String id, String lastName, String firstName, String email, String address, Set<OrderProduct> orderProducts) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.address = address;
        this.orderProducts = orderProducts;
    }

    public Order() {
    }

    public static OrderBuilder builder() {
        return new OrderBuilder();
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

    public Set<OrderProduct> getOrderProducts() {
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

    public void setOrderProducts(Set<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public static class OrderBuilder {
        private String id;
        private String lastName;
        private String firstName;
        private String email;
        private String address;
        private Set<OrderProduct> orderProducts;

        OrderBuilder() {
        }

        public OrderBuilder id(String id) {
            this.id = id;
            return this;
        }

        public OrderBuilder lastName(String lastName) {
            this.lastName = lastName;
            return this;
        }

        public OrderBuilder firstName(String firstName) {
            this.firstName = firstName;
            return this;
        }

        public OrderBuilder email(String email) {
            this.email = email;
            return this;
        }

        public OrderBuilder address(String address) {
            this.address = address;
            return this;
        }

        public OrderBuilder orderProducts(Set<OrderProduct> orderProducts) {
            this.orderProducts = orderProducts;
            return this;
        }

        public Order build() {
            return new Order(this.id, this.lastName, this.firstName, this.email, this.address, this.orderProducts);
        }

        public String toString() {
            return "Order.OrderBuilder(id=" + this.id + ", lastName=" + this.lastName + ", firstName=" + this.firstName + ", email=" + this.email + ", address=" + this.address + ", orderProducts=" + this.orderProducts + ")";
        }
    }
}
