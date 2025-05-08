package org.example;

import java.util.List;
import java.util.Locale;
import java.util.Objects;

public abstract class User {
    protected int id;
    protected String username;
    protected String password;

    private static int nextId = 1;

    public User(String username, String password) {
        this.id = nextId++;
        this.username = username;
        this.password = password;
    }

    /**
     * Checks if a user matches the given username and password by calling a helper method
     * @param username input username
     * @param password input password
     * @return true if the user has successfully logged in, otherwise false
     */
    public boolean login(String username, String password) {
        return UserManager.loginHelper(username, password);
    }

    /**
     * Logs out the currently logged-in user by calling a helper method
     * @return true if the user has successfully been logged out, otherwise false
     */
    public boolean logout() {
        return UserManager.logoutHelper();
    }

    /**
     * Searches the list of products based on an input category
     * Calls a helper method
     * @param category input category
     * @return the list of products in alphabetical order by name that corresponds to the input category
     */
    public List<Product> getProductsByCategory(Product.ProductCategory category) {
        return ProductManager.getProductsByCategoryHelper(category);
    }

    /**
     * Searches the list of products based on the given product id by calling a helper method
     * @param productId input product id
     * @return the product
     */
    public Product getProduct(String productId) {
        return ProductManager.getProductHelper(productId);
    }

    /**
     * Lets the user see all the products available
     * @return the list of all products
     */
    public List<Product> getProducts() {
        return ProductManager.getProducts();
    }

    /**
     * Searches the list of reviews of a product based on the given product id by calling a helper method
     * @param productId input product id
     * @return the list of reviews of the given product id
     */
    public List<Review> getProductReviews(String productId) {
        return ReviewManager.getProductReviewsHelper(productId);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(password, user.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static int getNextId() {
        return nextId;
    }

    public static void setNextId(int nextId) {
        User.nextId = nextId;
    }
}
