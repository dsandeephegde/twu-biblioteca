package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class BookList {

    private ArrayList<String> books;

    BookList() {
        books = new ArrayList<String>();
    }

    public void add(String book) {
        books.add(book);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String book : books)
            stringBuilder.append(book).append("\n");
        return stringBuilder.toString();
    }
}