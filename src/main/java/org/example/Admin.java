package org.example;

import java.util.List;

public class Admin extends User {
    public Admin(String username, String password) {
        super(username, password);
    }

    /**
     * Adds a new book as a product by calling a helper method
     * @param productId   id of the book
     * @param name        name of the book
     * @param price       price of the book
     * @param description description of the book
     * @param author      author of the book
     * @param isbn        isbn of the book
     * @return true if the book was successfully added, otherwise false
     */
    public boolean addBook(String productId, String name, double price, String description, String author, String isbn) {
        if (!Product.isProductValid(productId, name, price, description) || author == null || author.isBlank()
                || isbn == null || isbn.isBlank()) {
            return false;
        }
        return ProductManager.addBookHelper(productId, name, price, description, author, isbn);
    }

    /**
     * Adds a new clothing as a product by calling a helper method
     * @param productId   id of the clothing
     * @param name        name of the clothing
     * @param price       price of the clothing
     * @param description description of the clothing
     * @param size        size of the clothing
     * @param color       color of the clothing
     * @return true if the clothing was successfully added, otherwise false
     */
    public boolean addClothing(String productId, String name, double price, String description, Clothing.ClothingSize size, String color) {
        if (!Product.isProductValid(productId, name, price, description) || size == null || color == null || color.isBlank()) {
            return false;
        }
        return ProductManager.addClothingHelper(productId, name, price, description, size, color);
    }

    /**
     * Adds a new electronic as a product by calling a helper method
     * @param productId      id of the electronic
     * @param name           name of the electronic
     * @param price          price of the electronic
     * @param description    description of the electronic
     * @param warrantyMonths warranty in months
     * @param brand          brand of the electronic
     * @return true if the electronic was successfully added, otherwise false
     */
    public boolean addElectronic(String productId, String name, double price, String description, int warrantyMonths, String brand) {
        if (!Product.isProductValid(productId, name, price, description) || warrantyMonths < 0 || brand == null || brand.isBlank()) {
            return false;
        }
        return ProductManager.addElectronicHelper(productId, name, price, description, warrantyMonths, brand);
    }

    /**
     * Removes the product based on the given product id by calling a helper method
     * @param productId input product id
     * @return true if the product has been successfully removed, otherwise false
     */
    public boolean removeProduct(String productId) {
        return ProductManager.removeProductHelper(productId);
    }

    /**
     * Deletes a review based on the review id by calling a helper method
     * @param reviewId input review id
     * @return true if the review has been successfully deleted, otherwise false
     */
    public boolean deleteReview(int reviewId) {
        return ReviewManager.deleteReviewHelper(reviewId);
    }
}
