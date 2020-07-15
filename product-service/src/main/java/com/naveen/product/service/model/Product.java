package com.naveen.product.service.model;

import lombok.*;
import org.springframework.data.annotation.Id;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Product {

    @Id
    private Integer productId;
    private String productName;
    private Double productPrice;
    private Double productDiscount;
}
