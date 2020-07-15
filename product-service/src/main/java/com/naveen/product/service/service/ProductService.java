package com.naveen.product.service.service;

import com.naveen.product.service.exception.ProductNotFoundException;
import com.naveen.product.service.model.Product;
import com.naveen.product.service.repo.ProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService  implements  IProductService{
    @Autowired
    private ProductRepo productRepo;

    @Override
    public Product insertProduct(Product product) {

        return productRepo.insert(product);

    }

    @Override
    public Product updateProduct(Product product) throws  ProductNotFoundException{
        final Optional<Product> currentProduct = productRepo.findById(product.getProductId());

        if(currentProduct.isPresent()) {
            return this.productRepo.save(product);
        }

        return currentProduct.orElseThrow( () -> {
            return new ProductNotFoundException("Sorry Product With Id: " + product.getProductId() +" not found");
        });

    }

    @Override
    public Product getProduct(Integer productId) {

        final Optional<Product> product = productRepo.findById(productId);

        if(!product.isPresent()){
            throw new ProductNotFoundException("Sorry Product Not Found With Id: " + productId);
        }
        return product.get();
    }

    @Override
    public List<Product> getAllProducts() {

        return productRepo.findAll();
    }

    @Override
    public void deleteProduct(Integer productId) {
        productRepo.deleteById(productId);
    }

    @Override
    public List<String> getProductByName() {
        return productRepo.getProductByName();
    }
}
