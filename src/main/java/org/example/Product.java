package org.example;

import java.util.List;
import java.util.Objects;

public abstract class Product implements Comparable<Product> {
    protected String productId;
    protected String name;
    protected ProductCategory category;
    protected double price;
    protected String description;
    protected List<Review> reviews;

    public Product(String productId, String name, ProductCategory category, double price, String description, List<Review> reviews) {
        this.productId = productId;
        this.name = name;
        this.category = category;
        this.price = price;
        this.description = description;
        this.reviews = reviews;
    }

    public abstract void displayDetails();

    /**
     * Checks if the product basic details are valid
     * @param productId product id
     * @param name product name
     * @param price product price
     * @param description product description
     * @return true if the product is valid, otherwise false
     */
    public static boolean isProductValid(String productId, String name, double price, String description) {
        return (productId != null && name != null && !name.isBlank() && price >= 0 && description != null);
    }

    /**
     * Displays the basic details of a product
     */
    public void displayBasicDetails() {
        System.out.println("Name        : " + name);
        System.out.println("Category    : " + category);
        System.out.println("Price       : $" + price);
        System.out.println("Description : " + description);
    }

    /**
     * Calculates the average rating of a product
     * @return the average rating of the product
     */
    public double getAverageRating() {
        if (reviews.isEmpty()) {
            return 0;
        }
        double sum = reviews.stream()
                .mapToDouble(review -> review.getRating().getValue())
                .sum();
        double average = sum / reviews.size();
        return Math.round(average * 100.0) / 100.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Double.compare(price, product.price) == 0 && Objects.equals(productId, product.productId) && Objects.equals(name, product.name) && category == product.category && Objects.equals(description, product.description) && Objects.equals(reviews, product.reviews);
    }

    @Override
    public int hashCode() {
        return Objects.hash(productId, name, category, price, description, reviews);
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId='" + productId + '\'' +
                ", name='" + name + '\'' +
                ", category=" + category +
                ", price=" + price +
                ", description='" + description + '\'' +
                ", reviews=" + reviews +
                '}';
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ProductCategory getCategory() {
        return category;
    }

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public enum ProductCategory {
        ELECTRONIC, CLOTHING, BOOK
    }

    @Override
    public int compareTo(Product p) {
        return this.name.compareTo(p.name);
    }
}
