package org.example;

public interface Reviewable {
    boolean submitReview(int reviewId, String productId, int userId, Review.StarRating rating, String text);
}
