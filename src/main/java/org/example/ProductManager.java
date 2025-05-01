package org.example;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    public static List<Product> products = new ArrayList<>();

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
        //TODO (Updates the loadProduct method also)
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
        //TODO (Updates the loadProduct method also)
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
        //TODO (Updates the loadProduct method also)
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
                loadProducts();
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
        //TODO (Display category on top, product name, product id and average rating)
        return null;
    }

    /**
     * Helper method for the getProduct method in the user class
     * @param productId input product id
     * @return the product
     */
    public static Product getProductHelper(String productId) {
        //TODO (Connect the method with displayDetails())
        return null;
    }

    /**
     * Exports the products into a csv file
     */
    public static void loadProducts() {
        String filePath = "src/main/resources/products.csv";
        //TODO (TextIO O)
    }

    /**
     * Imports the products from a csv file
     * @param filePath path from content root of the file
     */
    public static ArrayList<Product> saveProducts(String filePath) {
        //TODO (TextIO I)
    }

    public static List<Product> getProducts() {
        return products;
    }
}
