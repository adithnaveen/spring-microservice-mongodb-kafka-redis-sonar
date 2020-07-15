package com.naveen.product.review.beans;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class ProductReview {

    @Id
    private int productId;
    private List<Review> review;
}
