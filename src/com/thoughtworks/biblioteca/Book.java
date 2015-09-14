//Stores name,author and year published of a book
package com.thoughtworks.biblioteca;

public class Book {

    private String name;
    private String author;
    private int yearPublished;

    public Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return String.format("%-40s%-40s%-40d", name, author, yearPublished);
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        Book book = (Book) that;
            return name.equals(book.name);
    }

    @Override
    public int hashCode() {
        return name != null ? name.hashCode() : 0;
    }
}