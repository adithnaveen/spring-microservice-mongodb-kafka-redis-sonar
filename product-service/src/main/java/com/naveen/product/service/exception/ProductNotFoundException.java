package com.naveen.product.service.exception;

public class ProductNotFoundException extends  RuntimeException{
    private String message;

    public ProductNotFoundException(String message) {
        super(message);
    }
}

