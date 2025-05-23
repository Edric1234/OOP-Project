import org.example.Electronic;
import org.example.Product;
import org.example.Review;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ProductTest {
    @Test //General case
    public void testGetAverageRating() {
        Review r1 = new Review("123-123-123", 1, Review.StarRating.FIVE, "", LocalDate.now());
        Review r2 = new Review("123-123-123", 2, Review.StarRating.ONE, "", LocalDate.now());
        Review r3 = new Review("123-123-123", 3, Review.StarRating.FIVE, "", LocalDate.now());

        Electronic electronic = new Electronic("1", "Apple", Product.ProductCategory.ELECTRONIC, 2,
                "", List.of(r1, r2, r3), 1, "");

        double expected = 3.67;
        double result = electronic.getAverageRating();
        Assertions.assertEquals(expected, result);
    }
}
