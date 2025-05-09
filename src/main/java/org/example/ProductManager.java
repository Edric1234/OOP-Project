package org.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
    public static List<Product> products = new ArrayList<>();

    /**
     * Checks if a product with the given productId already exist
     * @param productId product id
     * @return true if the product already exists, otherwise false
     */
    public static boolean doesProductExist(String productId) {
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Helper method for the addBook method in the admin class
     * @param productId   id of the book
     * @param name        name of the book
     * @param price       price of the book
     * @param description description of the book
     * @param author      author of the book
     * @param isbn        isbn of the book
     * @return true if the book was successfully added, otherwise false
     */
    public static boolean addBookHelper(String productId, String name, double price, String description, String author, String isbn) {
        if (doesProductExist(productId)) {
            return false;
        }
        products.add(new Book(productId, name, Product.ProductCategory.BOOK, price, description, new ArrayList<>(), author, isbn));
        saveProducts();
        return true;
    }

    /**
     * Helper method for the addClothing method in the admin class
     * @param productId   id of the clothing
     * @param name        name of the clothing
     * @param price       price of the clothing
     * @param description description of the clothing
     * @param size        size of the clothing
     * @param color       color of the clothing
     * @return true if the clothing was successfully added, otherwise false
     */
    public static boolean addClothingHelper(String productId, String name, double price, String description, Clothing.ClothingSize size, String color) {
        if (doesProductExist(productId)) {
            return false;
        }
        products.add(new Clothing(productId, name, Product.ProductCategory.CLOTHING, price, description, new ArrayList<>(), size, color));
        saveProducts();
        return true;
    }

    /**
     * Helper method  for the addElectronic method in the admin class
     * @param productId      id of the electronic
     * @param name           name of the electronic
     * @param price          price of the electronic
     * @param description    description of the electronic
     * @param warrantyMonths warranty in months
     * @param brand          brand of the electronic
     * @return true if the electronic was successfully added, otherwise false
     */
    public static boolean addElectronicHelper(String productId, String name, double price, String description, int warrantyMonths, String brand) {
        if (doesProductExist(productId)) {
            return false;
        }
        products.add(new Electronic(productId, name, Product.ProductCategory.ELECTRONIC, price, description, new ArrayList<>(), warrantyMonths, brand));
        saveProducts();
        return true;
    }

    /**
     * Helper method for the removeProduct method in the admin class
     * @param productId input product id
     * @return true the product has been successfully removed, otherwise false
     */
    public static boolean removeProductHelper(String productId) {
        for (Product product : products) {
            if (productId.equals(product.getProductId())) {
                products.remove(product);
                saveProducts();
                System.out.println("Product has been successfully removed");
                return true;
            }
        }
        System.out.println("Product id not found");
        return false;
    }

    /**
     * Helper method for the getProducts method in the user class
     * @param category input category
     * @return the list of products in alphabetical order by name that corresponds to the input category
     */
    public static List<Product> getProductsByCategoryHelper(Product.ProductCategory category) {
        List<Product> result = new ArrayList<>();
        for (Product product : products) {
            if (product.getCategory().equals(category)) {
                result.add(product);
            }
        }
        return result;
    }

    /**
     * Helper method for the getProduct method in the user class
     * @param productId input product id
     * @return the product
     */
    public static Product getProductHelper(String productId) {
        if (!doesProductExist(productId)) {
            return null;
        }
        for (Product product : products) {
            if (product.getProductId().equals(productId)) {
                return product;
            }
        }
        return null;
    }

    /**
     * Exports the products into a csv file
     */
    public static void saveProducts() {
        String filePath = "src/main/resources/products.csv";
        File file = new File(filePath);

        try (FileWriter fw = new FileWriter(file)) {
            for (Product product : products) {
                fw.write(product.getProductId() + ",");
                fw.write(product.getName() + ",");
                fw.write(product.getCategory() + ",");
                fw.write(product.getPrice() + ",");
                fw.write(product.getDescription() + ",");

                for (Review review : product.getReviews()) {
                    fw.write(review.getReviewId() + ",");
                    fw.write(review.getProductId() + ",");
                    fw.write(review.getUserId() + ",");
                    fw.write(review.getRating() + ",");
                    fw.write(review.getText() + ",");
                    fw.write(review.getDate() + ",");
                }

                switch (product) {
                    case Book book -> {
                        fw.write(book.getAuthor() + ",");
                        fw.write(book.getIsbn() + "\n");
                    }
                    case Clothing clothing -> {
                        fw.write(clothing.getSize() + ",");
                        fw.write(clothing.getColor() + "\n");
                    }
                    case Electronic electronic -> {
                        fw.write(electronic.getWarrantyMonths() + ",");
                        fw.write(electronic.getBrand() + "\n");
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + product);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Imports the products from a csv file
     * @param filePath path of the file from content root
     * @return the arraylist of  all products that contain all their information
     */
    public static ArrayList<Product> loadProducts(String filePath) {
        ArrayList<Product> result = new ArrayList<>();
        File file = new File(filePath);

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                String productId = parts[0];
                String name = parts[1];
                Product.ProductCategory category = Product.ProductCategory.valueOf(parts[2]);
                double price = Double.parseDouble(parts[3]);
                String description = parts[4];
                List<Review> reviews = new ArrayList<>();
                int i = 5;
                if (parts.length != 8) {
                    while (i < parts.length - 2) {
                        int reviewId = Integer.parseInt(parts[i++]);
                        String productIdReview = parts[i++];
                        int userId = Integer.parseInt(parts[i++]);
                        Review.StarRating rating = Review.StarRating.valueOf(parts[i++]);
                        String text = parts[i++];
                        LocalDate date = LocalDate.parse(parts[i++]);
                        reviews.add(new Review(reviewId, productIdReview, userId, rating, text, date));
                    }
                }
                if (category.equals(Product.ProductCategory.BOOK)) {
                    String author = parts[parts.length - 2];
                    String isbn = parts[parts.length - 1];
                    result.add(new Book(productId, name, category, price, description, reviews, author, isbn));
                } else if (category.equals(Product.ProductCategory.CLOTHING)) {
                    Clothing.ClothingSize size = Clothing.ClothingSize.valueOf(parts[parts.length - 2]);
                    String color = parts[parts.length - 1];
                    result.add(new Clothing(productId, name, category, price, description, reviews, size, color));
                } else if (category.equals(Product.ProductCategory.ELECTRONIC)) {
                    int warrantyMonths = Integer.parseInt(parts[parts.length - 2]);
                    String brand = parts[parts.length - 1];
                    result.add(new Electronic(productId, name, category, price, description, reviews, warrantyMonths, brand));
                }
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public static List<Product> getProducts() {
        return products;
    }
}
