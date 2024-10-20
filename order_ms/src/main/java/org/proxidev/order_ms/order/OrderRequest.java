package org.proxidev.order_ms.order;

import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class OrderRequest {
    private String lastName;
    private String firstName;
    private String email;
    private String address;
    private Set<OrderProductRequest> orderProducts;

}
