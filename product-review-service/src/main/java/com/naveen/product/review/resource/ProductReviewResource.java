package com.naveen.product.review.resource;

import com.naveen.product.review.beans.ProductReview;
import com.naveen.product.review.beans.Review;
import com.naveen.product.review.service.IProductReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductReviewResource {
    @Autowired
    private IProductReviewService productReviewService;

    @GetMapping("/")
    public String defualt() {
        return "working";
    }

    @PostMapping("/product-review")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductReview saveProductReview(@RequestBody  ProductReview productReview) {
        return productReviewService.saveReveiw(productReview);
    }


    @GetMapping("/product-review")
    @ResponseStatus(code = HttpStatus.OK)
    public List<ProductReview> getAllProductReviews () {
        return productReviewService.getAllReviews();
    }

    @GetMapping("/product-review/reviews/{productId}")
    public List<Review> getAllReviewForProduct(@PathVariable  Integer productId) {
        return productReviewService.getAllReviewForProduct(productId);
    }

    @GetMapping("/product-review/reviews/{productId}/{reviewId}")
    public List<Review> getReviewByIdForProduct(@PathVariable Integer productId, @PathVariable Integer reviewId) {
        System.out.println("in getReviewByIdForProduct"+ productId +", " + reviewId);
        return productReviewService.getProductReviewById(productId, reviewId);
    }
    @GetMapping("/product-review/{productId}")
    public ProductReview getProductReview(@PathVariable Integer productId) {
        return productReviewService.getProductReview(productId);
    }

    @PostMapping("/product-review/{productId}")
    @ResponseStatus(code = HttpStatus.CREATED)
    public ProductReview saveReviewForProduct(@PathVariable Integer productId, @RequestBody Review review) {
        return productReviewService.saveReveiwForProduct(productId, review);
    }


}
