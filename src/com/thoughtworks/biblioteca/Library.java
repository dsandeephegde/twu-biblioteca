//Stores the List of Books which can be checked out or returned
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks;
    private View view;

    public Library(ArrayList<Book> availableBooks, View view) {
        this.availableBooks = availableBooks;
        this.checkedOutBooks = new ArrayList<Book>();
        this.view = view;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Book Name\t").append("Author\t").append("Year Published\n");
        for(Book book : availableBooks) {
            stringBuilder.append(book.toString()).append("\n");
        }
        return stringBuilder.toString();
    }

    public void displayBookList() {
        view.output(toString());
    }

    public Boolean checkoutBook(String bookName) {
        Book searchableBook = new Book(bookName, null, 0);
        for(Book book: availableBooks) {
            if (book.equals(searchableBook)) {
                checkedOutBooks.add(book);
                availableBooks.remove(book);
                return true;
            }
        }
        return false;
    }

    public Boolean returnBook(String bookName) {
        Book searchableBook = new Book(bookName, null, 0);
        for (Book book : checkedOutBooks) {
            if (book.equals(searchableBook)) {
                availableBooks.add(book);
                checkedOutBooks.remove(book);
                return true;
            }
        }
        return false;
    }
}