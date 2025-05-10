package org.example;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ReviewManager {
    public static List<Review> reviews = new ArrayList<>();
    public static List<Product> products = ProductManager.getProducts();

    /**
     * Submits the review of the user based on a given product id
     * Helper method of the submitReview method in the customer class
     * @param productId product id
     * @param userId    user id
     * @param rating    rating of product from the customer
     * @param text      text of the review
     * @return true if the review has been successfully submitted, otherwise false
     */
    public static boolean submitReviewHelper(String productId, int userId, Review.StarRating rating, String text) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                for (Review review : product.getReviews()) {
                    if (review.getUserId() == userId) {
                        System.out.println("User already reviewed this product");
                        return false;
                    }
                }
                Review result = new Review(productId, userId, rating, text, LocalDate.now());
                product.getReviews().add(result);
                reviews.add(result);
                System.out.println("Review submitted");
                return true;
            }
        }
        System.out.println("Couldn't find product with id: " + productId);
        return false;
    }

    /**
     * Deletes a review based on the review id
     * Helper method for the deleteReview method of the admin class
     * @param reviewId input review id
     * @return true if the review has been successfully deleted, otherwise false
     */
    public static boolean deleteReviewHelper(int reviewId) {
        for (Product product : products) {
            for (Review review : product.getReviews()) {
                if (review.getReviewId() == reviewId) {
                    product.getReviews().remove(review);
                    reviews.remove(review);
                    System.out.println("Review removed");
                    return true;
                }
            }
        }
        System.out.println("Couldn't find review with id: " + reviewId);
        return false;
    }

    /**
     * Searches the list of reviews based on the given id product
     * Helper method for the getProductReviews method of the user class
     * @param productId input product id
     * @return the list of reviews of the given product id
     */
    public static List<Review> getProductReviewsHelper(String productId) {
        List<Review> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                result.addAll(product.getReviews());
            }
        }
        return result;
    }

    public List<Review> getReviews() {
        return reviews;
    }
}
