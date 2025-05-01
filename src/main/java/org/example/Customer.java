package org.example;

public class Customer extends User implements Reviewable {
    public Customer(String username, String password) {
        super(username, password);
    }

    /**
     * Submits the review of the user based on a given product id
     * Calls a helper method
     * @param reviewId  review id
     * @param productId product id
     * @param userId    user id
     * @param rating    rating of the product given by the customer
     * @param text      text of the review
     * @return true if the review has successfully been submitted, otherwise false
     */
    @Override
    public boolean submitReview(int reviewId, String productId, int userId, Review.StarRating rating, String text) {
        return ReviewManager.submitReviewHelper(reviewId, productId, userId, rating, text);
    }
}
