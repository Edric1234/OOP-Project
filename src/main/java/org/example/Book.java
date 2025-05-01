package org.example;

import java.util.List;
import java.util.Objects;

public class Book extends Product {
    private String author;
    private String isbn;

    public Book(String productId, String name, ProductCategory category, double price, String description, List<Review> reviews, String author, String isbn) {
        super(productId, name, category, price, description, reviews);
        this.author = author;
        this.isbn = isbn;
    }

    /**
     * Displays the details of the book product
     */
    @Override
    public void displayDetails() {
        System.out.println("Book details");
        displayBasicDetails();
        System.out.println("Author      : " + author);
        System.out.println("ISBN        : " + isbn);
        System.out.println("Star rating : " + getAverageRating());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Book book = (Book) o;
        return Objects.equals(author, book.author) && Objects.equals(isbn, book.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), author, isbn);
    }

    @Override
    public String toString() {
        return "Book{" +
                "author='" + author + '\'' +
                ", isbn='" + isbn + '\'' +
                '}' + super.toString();
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
}
