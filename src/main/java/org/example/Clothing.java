package org.example;

import java.util.List;
import java.util.Objects;

public class Clothing extends Product {
    private ClothingSize size;
    private String color;

    public Clothing(String productId, String name, ProductCategory category, double price, String description, List<Review> reviews, ClothingSize size, String color) {
        super(productId, name, category, price, description, reviews);
        this.size = size;
        this.color = color;
    }

    /**
     * Displays the detail of the clothing product
     */
    @Override
    public void displayDetails() {
        System.out.println("Clothing details");
        displayBasicDetails();
        System.out.println("Size        : " + size);
        System.out.println("Color       : " + color);
        System.out.println("Star rating : " + getAverageRating());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Clothing clothing = (Clothing) o;
        return size == clothing.size && Objects.equals(color, clothing.color);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), size, color);
    }

    @Override
    public String toString() {
        return "Clothing{" +
                "size=" + size +
                ", color='" + color + '\'' +
                '}' + super.toString();
    }

    public ClothingSize getSize() {
        return size;
    }

    public void setSize(ClothingSize size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public enum ClothingSize {
        XS, S, M, L, XL
    }
}
