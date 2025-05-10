package org.example;

public interface Reviewable {
    boolean submitReview(String productId, int userId, Review.StarRating rating, String text);
}
