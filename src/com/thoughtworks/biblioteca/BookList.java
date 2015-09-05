//Stores the List of Books
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class BookList {

    private ArrayList<Book> books;

    BookList(ArrayList<Book> books) {
        this.books = books;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (Book book : books)
            stringBuilder.append(book.toString()).append("\n");
        return stringBuilder.toString();
    }
}