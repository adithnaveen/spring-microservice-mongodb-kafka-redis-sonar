package com.naveen.product.review.config;


import com.naveen.product.review.beans.ProductReview;
import com.naveen.product.review.beans.Review;
import com.naveen.product.review.repo.ProductReviewRepo;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import java.util.Arrays;
import java.util.Date;

@Configuration
@EnableMongoRepositories(basePackageClasses = ProductReviewRepo.class)
public class MongoConfig {

    @Bean
    public CommandLineRunner commandLineRunner (ProductReviewRepo productReviewRepo) {
        return string -> {
//            productReviewRepo.insert( new ProductReview(101, Arrays.asList( new Review
//                    (101, "Naveen", "Good Product",new Date()) ) ) );
        };
    }

}
