package com.naveen.product.review.service;

import com.naveen.product.review.beans.ProductReview;
import com.naveen.product.review.beans.Review;
import com.naveen.product.review.exception.ProductReviewNotFouncException;

import java.util.List;

public interface IProductReviewService {

    public ProductReview saveReveiw(ProductReview productReview);

    // save only review
    public ProductReview saveReveiwForProduct(Integer productId, Review review) ;

    public List<ProductReview> getAllReviews();

    public ProductReview getProductReview(Integer productId) throws ProductReviewNotFouncException;

    public List<Review> getProductReviewById(Integer productId, Integer reviewId);

    public List<Review> getAllReviewForProduct(Integer productId);

}
