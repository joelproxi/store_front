package org.proxidev.order_ms.order;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter @Builder
@Entity @Table(name = "order_products")
public class OrderProduct {
    @Id @GeneratedValue
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
}
