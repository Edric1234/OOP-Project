package org.example;

import java.util.List;
import java.util.Objects;

public class Electronic extends Product {
    private int warrantyMonths;
    private String brand;

    public Electronic(String productId, String name, ProductCategory category, double price, String description, List<Review> reviews, int warrantyMonths, String brand) {
        super(productId, name, category, price, description, reviews);
        this.warrantyMonths = warrantyMonths;
        this.brand = brand;
    }

    /**
     * Display the details of the electronic product
     */
    @Override
    public void displayDetails() {
        System.out.println("Electronic details");
        displayBasicDetails();
        System.out.println("Warranty    : " + warrantyMonths + " months");
        System.out.println("Brand       : " + brand);
        System.out.println("Star rating : " + getAverageRating());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Electronic that = (Electronic) o;
        return warrantyMonths == that.warrantyMonths && Objects.equals(brand, that.brand);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), warrantyMonths, brand);
    }

    @Override
    public String toString() {
        return "Electronic{" +
                "warrantyMonths=" + warrantyMonths +
                ", brand='" + brand + '\'' +
                '}' + super.toString();
    }

    public int getWarrantyMonths() {
        return warrantyMonths;
    }

    public void setWarrantyMonths(int warrantyMonths) {
        this.warrantyMonths = warrantyMonths;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }
}
