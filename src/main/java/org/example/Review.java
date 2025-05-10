package org.example;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.Objects;

public class Review {
    private int reviewId;
    private String productId;
    private int userId;
    private StarRating rating;
    private String text;
    private LocalDate date;

    private static int nextReviewId = 1;

    public Review(String productId, int userId, StarRating rating, String text, LocalDate date) {
        this.reviewId = nextReviewId++;
        this.productId = productId;
        this.userId = userId;
        this.rating = rating;
        this.text = text;
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return reviewId == review.reviewId && userId == review.userId && Objects.equals(productId, review.productId) && rating == review.rating && Objects.equals(text, review.text) && Objects.equals(date, review.date);
    }

    @Override
    public int hashCode() {
        return Objects.hash(reviewId, productId, userId, rating, text, date);
    }

    @Override
    public String toString() {
        return "Review{" +
                "reviewId=" + reviewId +
                ", productId='" + productId + '\'' +
                ", userId=" + userId +
                ", rating=" + rating +
                ", text='" + text + '\'' +
                ", date=" + date +
                '}';
    }

    public int getReviewId() {
        return reviewId;
    }

    public void setReviewId(int reviewId) {
        this.reviewId = reviewId;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public StarRating getRating() {
        return rating;
    }

    public void setRating(StarRating rating) {
        this.rating = rating;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public static int getNextReviewId() {
        return nextReviewId;
    }

    public static void setNextReviewId(int nextReviewId) {
        Review.nextReviewId = nextReviewId;
    }

    public enum StarRating {
        ONE(1), TWO(2), THREE(3), FOUR(4), FIVE(5);

        private final int value;

        StarRating(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public static class ReviewComparator implements Comparator<Review> {
        private final String type;

        public ReviewComparator(String type) {
            this.type = type;
        }

        @Override
        public int compare(Review r1, Review r2) {
            return switch (type.toLowerCase()) {
                case "date" -> (r1.getDate().equals(r2.getDate()))
                        ? r1.getRating().value - r2.getRating().value
                        : r2.getDate().compareTo(r1.getDate());
                case "rating" -> (r1.getRating().value == r2.getRating().value)
                        ? r1.getText().length() - r2.getText().length()
                        : r2.getRating().value - r1.getRating().value;
                default -> (r1.getText().length() == r2.getText().length())
                        ? r1.getDate().compareTo(r2.getDate())
                        : r2.getText().length() - r1.getText().length();
            };
        }
    }
}
