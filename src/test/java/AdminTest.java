import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AdminTest {
    @Test //General case
    public void testAddBook() {
        Admin admin = new Admin("Mark", "12345");

        boolean expected = true;
        boolean result = admin.addBook("123-123-123", "Java", 20, "...", "Mark",
                "978-0-306-40615-7");

        Assertions.assertEquals(expected, result);
    }

    @Test  //General case
    public void testAddClothing() {
        Admin admin = new Admin("Mark", "12345");

        boolean expected = true;
        boolean result = admin.addClothing("123-123-123", "Nike", 20, "...",
                Clothing.ClothingSize.L, "blue");

        Assertions.assertEquals(expected, result);
    }

    @Test //General case
    public void testAddElectronic() {
        Admin admin = new Admin("Mark", "12345");

        boolean expected = true;
        boolean result = admin.addElectronic("123-123-123", "IPhone", 20, "...",
                6, "Apple");

        Assertions.assertEquals(expected, result);
    }

    @Test //General case
    public void testRemoveProduct() {
        Admin admin = new Admin("Mark", "12345");
        ProductManager.products.add(new Electronic("123-123-123", "IPhone",
                Product.ProductCategory.ELECTRONIC, 20, "", new ArrayList<>(), 6,
                "Apple"));

        boolean result = admin.removeProduct("123-123-123");
        boolean expected = true;

        Assertions.assertEquals(expected, result);
    }

    @Test //General case
    public void testDeleteReview() {
        Admin admin = new Admin("Mark", "12345");
        ProductManager.products.add(new Electronic("123-123-123", "IPhone",
                Product.ProductCategory.ELECTRONIC, 20, "", new ArrayList<>(), 6,
                "Apple"));
        Review r1 = new Review(1, "123-123-123", 1, Review.StarRating.ONE, "...", LocalDate.now());
        ProductManager.products.get(0).getReviews().add(r1);
        ReviewManager.reviews.add(r1);

        boolean result = admin.deleteReview(1);
        boolean expected = true;

        Assertions.assertEquals(expected, result);
    }
}
