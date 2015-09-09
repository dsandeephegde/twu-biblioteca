//Stores the List of Books
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> books;
    private ArrayList<Boolean> checkedOutBooks;

    Library(ArrayList<Book> books) {
        this.books = books;
        checkedOutBooks = new ArrayList<Boolean>();
        for (int i = 0; i < books.size(); i++) {
            checkedOutBooks.add(false);
        }
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("Book Name\t").append("Author\t").append("Year Published\n");
        for (int i = 0; i < books.size(); i++) {
            if(!checkedOutBooks.get(i)) {
                stringBuilder.append(books.get(i).toString()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    public void displayBookList() {
        Display display = new Display(toString());
        display.display();
    }

    public Boolean checkout(String bookName) {
        for(Book book: books) {
            if(book.hasName(bookName)) {
                checkedOutBooks.set(books.indexOf(book), true);
                return true;
            }
        }
        return false;
    }

    public void returnBook(String bookName) {
        for (Book book : books) {
            if (book.hasName(bookName)) {
                checkedOutBooks.set(books.indexOf(book), false);
            }
        }
    }
}