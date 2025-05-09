import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;

public class CustomerTest {
    @Test //General case
    public void testSubmitReview() {
        Customer customer = new Customer("Mark", "123");
        Electronic electronic = new Electronic("123-123-123", "IPhone",
                Product.ProductCategory.ELECTRONIC, 20, "", new ArrayList<>(), 6,
                "Apple");
        ProductManager.products.add(electronic);

        boolean result = customer.submitReview(1, "123-123-123", 1, Review.StarRating.ONE, "");
        boolean expected = true;

        Assertions.assertEquals(expected, result);

    }
}
