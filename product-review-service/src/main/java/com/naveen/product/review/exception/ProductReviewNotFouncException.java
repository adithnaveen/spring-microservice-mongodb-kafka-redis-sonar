package com.naveen.product.review.exception;

public class ProductReviewNotFouncException extends  RuntimeException{
    private String message;
    public ProductReviewNotFouncException(String message) {
        super(message);
    }
}
