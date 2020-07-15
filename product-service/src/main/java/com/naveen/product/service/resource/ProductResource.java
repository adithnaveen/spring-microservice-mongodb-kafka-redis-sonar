package com.naveen.product.service.resource;


import com.naveen.product.service.exception.ProductNotFoundException;
import com.naveen.product.service.model.Product;
import com.naveen.product.service.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ProductResource {

    @Autowired
    private IProductService productService;

    // http://localhost:9100/api/product - POST
    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public Product insertProduct(@RequestBody Product product) {
        return productService.insertProduct(product);
    }

    // http://localhost:9100/api/product/{productId} - GET

    @GetMapping("/product/{productId}")
    @ResponseStatus(HttpStatus.OK)
    public Product getProduct(@PathVariable Integer productId) {
        Product product = productService.getProduct(productId);
        try {

            if (product == null) {
                throw new ProductNotFoundException("Sorry Product not Found: " + productId);
            }
            return product;
        } catch (ProductNotFoundException pnfe) {
            pnfe.printStackTrace();
            throw new ProductNotFoundException(pnfe.getMessage());
        }

    }

    @GetMapping("/products")
    @ResponseStatus(HttpStatus.OK)
    public List<Product> getAllProduct() {
        return productService.getAllProducts();
    }

    @DeleteMapping("/product/{productId}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Integer productId) {
        productService.deleteProduct(productId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/product")
    public Product updateProduct(@RequestBody Product product)
            throws ProductNotFoundException {
        try {
            return productService.updateProduct(product);
        } catch (ProductNotFoundException pnfe) {
            pnfe.printStackTrace();
            throw new ProductNotFoundException("Sorry Product Id Not Found to Update: " + product.getProductId());
        }
    }

    @GetMapping("/product/names")
    public List<String> getProductNames() {
        return productService.getProductByName();
    }
}