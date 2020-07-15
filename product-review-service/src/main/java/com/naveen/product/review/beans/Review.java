package com.naveen.product.review.beans;

import lombok.*;
import org.springframework.data.annotation.Id;

import java.util.Date;

//
//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor
//@ToString
public class Review {
        @Id
        private Integer reviewId;
        private String reviewerName;
        private String message;
        private Date date;

        public Review(){}

        public Review(Integer reviewId, String reviewerName, String message, Date date) {
                this.reviewId = reviewId;
                this.reviewerName = reviewerName;
                this.message = message;
                this.date = date;
        }

        public Integer getReviewId() {
                return reviewId;
        }

        public void setReviewId(Integer reviewId) {
                this.reviewId = reviewId;
        }

        public String getReviewerName() {
                return reviewerName;
        }

        public void setReviewerName(String reviewerName) {
                this.reviewerName = reviewerName;
        }

        public String getMessage() {
                return message;
        }

        public void setMessage(String message) {
                this.message = message;
        }

        public Date getDate() {
                return date;
        }

        public void setDate(Date date) {
                this.date = date;
        }
}
