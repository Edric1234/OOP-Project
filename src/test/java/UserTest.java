import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class UserTest {
    @Test
    public void testLogin() {
        Customer customer = new Customer("Mark", "123");
        UserManager.getUsers().add(customer);

        boolean expected = true;
        boolean result = customer.login("Mark", "123");

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testLogout() {
        Customer customer = new Customer("Mark", "123");
        UserManager.getUsers().add(customer);
        customer.login("Mark", "123"); // Login first

        boolean expected = true;
        boolean result = customer.logout();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetProductsByCategory() {
        Electronic electronic = new Electronic("E1", "Laptop", Product.ProductCategory.ELECTRONIC,
                999, "High-end laptop", new ArrayList<>(), 12, "Dell");
        Book book = new Book("B1", "Clean Code", Product.ProductCategory.BOOK, 20,
                "Programming book", new ArrayList<>(), "", "978-0132350884");
        ProductManager.products.add(electronic);
        ProductManager.products.add(book);

        User user = new Customer("Mark", "123");

        List<Product> result = user.getProductsByCategory(Product.ProductCategory.ELECTRONIC);
        List<Product> expected = new ArrayList<>();
        expected.add(electronic);

        Assertions.assertEquals(expected, result);

    }

    @Test
    public void testGetProduct() {
        Product testProduct = new Electronic("E1", "Laptop", Product.ProductCategory.ELECTRONIC,
                999, "High-end laptop", new ArrayList<>(), 12, "Dell");
        Book book = new Book("B1", "Clean Code", Product.ProductCategory.BOOK, 20,
                "Programming book", new ArrayList<>(), "", "978-0132350884");
        ProductManager.products.add(testProduct);

        User user = new Customer("test", "pass");
        Product result = user.getProduct("P123");

        Assertions.assertEquals(testProduct, result);
    }

    @Test
    public void testGetProducts() {
        Electronic electronic = new Electronic("1", "Laptop", Product.ProductCategory.ELECTRONIC,
                999, "High-end laptop", new ArrayList<>(), 12, "Dell");
        Book book = new Book("B1", "Clean Code", Product.ProductCategory.BOOK, 20,
                "Programming book", new ArrayList<>(), "", "978-0132350884");
        ProductManager.products.add(electronic);
        ProductManager.products.add(book);
        User user = new Customer("test", "pass");

        List<Product> expected = new ArrayList<>();
        expected.add(electronic);
        expected.add(book);
        List<Product> result = user.getProducts();

        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testGetProductReviews() {
        Electronic electronic = new Electronic("P1", "Laptop", Product.ProductCategory.ELECTRONIC,
                999, "High-end laptop", new ArrayList<>(), 12, "Dell");
        Review review1 = new Review(1, "P1", 1, Review.StarRating.FIVE, "Great!");
        Review review2 = new Review(2, "P1", 2, Review.StarRating.FOUR, "Good");
        electronic.getReviews().add(review1);
        electronic.getReviews().add(review2);

        List<Review> expected = new ArrayList<>();
        expected.add(review1);
        expected.add(review2);
        User user = new Customer("test", "pass");
        List<Review> result = user.getProductReviews(1); // Assuming productId is int

        Assertions.assertEquals(expected, result);
    }
}
