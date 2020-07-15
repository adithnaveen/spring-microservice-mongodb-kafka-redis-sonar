package com.naveen.product.review.service;

import com.naveen.product.review.beans.ProductReview;
import com.naveen.product.review.beans.Review;
import com.naveen.product.review.exception.ProductReviewNotFouncException;
import com.naveen.product.review.repo.ProductReviewRepo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductReviewService implements  IProductReviewService {

    final Logger logger = LoggerFactory.getLogger(ProductReviewService.class);

    @Autowired
    private ProductReviewRepo productReviewRepo;

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public ProductReview saveReveiw(ProductReview productReview) {
        return productReviewRepo.save(productReview);
    }

 //    @Override
//    public ProductReview saveReveiwForProduct(Integer productId, Review review) {
//       ProductReview productReview = this.getProductReview(productId);
//
//       productReview.getReview().add(review);
//       this.saveReveiw(productReview);
//
//       return getProductReview(productId);
//    }


    @Override
    public ProductReview saveReveiwForProduct(Integer productId, Review review) {
        Query query = new Query(Criteria.where("_id").is(productId));
        Update updateReview = new Update().push("review", review);

        mongoTemplate.findAndModify(query, updateReview, ProductReview.class);

        return this.getProductReview(productId);
    }



    @Override
    public List<ProductReview> getAllReviews() {
        return productReviewRepo.findAll();
    }

    @Override
    public ProductReview getProductReview(Integer productId)
            throws  ProductReviewNotFouncException {
        final Optional<ProductReview> findById = productReviewRepo.findById(productId);

        ProductReview productReview = null;

        if(findById.isPresent()) {
            productReview = findById.get();
        }

        productReviewRepo.findById(productId).<ProductReviewNotFouncException>orElseThrow(() -> {
            logger.error("Product Not Found with Id : " + productId);

                throw new ProductReviewNotFouncException("Product Not Found with Id : " + productId);

        });

        return productReview;

    }

    @Override
    public List<Review> getProductReviewById(Integer productId, Integer reviewId) {
        System.out.println("in getProductReviewById -> "+ productId +", " + reviewId);

        return productReviewRepo.getProductReviewById(productId, reviewId);
    }

    @Override
    public List<Review> getAllReviewForProduct(Integer productId) {
       return getProductReview(productId).getReview();
    }
}
