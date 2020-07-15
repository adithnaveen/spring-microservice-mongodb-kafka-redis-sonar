package com.naveen.product.service.service;


import com.naveen.product.service.model.Product;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IProductService {
    public Product insertProduct(Product product);

    public Product updateProduct(Product product);

    public Product getProduct(Integer productId);

    public List<Product> getAllProducts();

    public void deleteProduct(Integer productId);

    // Custom Query
    public List<String> getProductByName();
}
