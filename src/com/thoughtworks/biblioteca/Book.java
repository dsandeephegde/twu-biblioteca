package com.thoughtworks.biblioteca;

public class Book {

    private String name;
    private String author;
    private int yearPublished;

    Book(String name, String author, int yearPublished) {
        this.name = name;
        this.author = author;
        this.yearPublished = yearPublished;
    }

    @Override
    public String toString() {
        return name + "\t" + author + "\t" + yearPublished;
    }
}
