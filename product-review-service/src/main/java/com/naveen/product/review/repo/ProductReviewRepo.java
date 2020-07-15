package com.naveen.product.review.repo;

import com.naveen.product.review.beans.ProductReview;
import com.naveen.product.review.beans.Review;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductReviewRepo  extends MongoRepository<ProductReview, Integer> {

//  @Query(value="{'_id':?0, 'review.reviewId':?1 }", fields = "{'_id':0, 'review.$':1}")
//    @Query(value="{'_id':?0, 'review.reviewId':?1 }", fields = "{'_id':0, 'review.$':1}")
//    public List<Review> getProductReviewById(Integer productId, Integer reviewId);

    @Query(value="{'_id':?0, 'review.reviewId':?1 }", fields = "{'_id':0, 'review.$':1}")
    public List<Review> getProductReviewById(Integer productId, Integer reviewId);
}
