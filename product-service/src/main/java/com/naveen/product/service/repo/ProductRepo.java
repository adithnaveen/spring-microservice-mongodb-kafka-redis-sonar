package com.naveen.product.service.repo;

import com.naveen.product.service.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

// CRUD (Insert, Delete, Select, Update, SelectAll)
public interface ProductRepo extends MongoRepository<Product, Integer> {
    @Query(value="{}", fields = "{'productName':1}")
    public List<String> getProductByName();
}
