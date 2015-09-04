//Stores the List of Books
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class BookList {

    private ArrayList<String> books;

    BookList(ArrayList<String> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (String book : books)
            stringBuilder.append(book).append("\n");
        return stringBuilder.toString();
    }
}