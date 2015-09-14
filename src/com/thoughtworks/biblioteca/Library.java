//Stores the List of Books which can be checked out or returned
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Library {

    private ArrayList<Book> availableBooks;
    private ArrayList<Book> checkedOutBooks;
    private ArrayList<Movie> movies;
    private View view;

    public Library(ArrayList<Book> books, ArrayList<Movie> movies, View view) {
        this.availableBooks = books;
        this.movies = movies;
        this.checkedOutBooks = new ArrayList<Book>();
        this.view = view;
    }

    public void displayMovieList() {
        String listMovieString = "";
        listMovieString += String.format("%-40s%-40s%-40s", "Movie Name", "Director", "Rating") + "\n";
        for(Movie movie : movies) {
            listMovieString += movie.toString() + "\n";
        }
        view.output(listMovieString);
    }

    public void displayBookList() {
        String listBookString = "";
        listBookString += String.format("%-40s%-40s%-40s", "Book Name", "Author", "Year Published") + "\n";
        for(Book book : availableBooks) {
            listBookString += book.toString() + "\n";
        }
        view.output(listBookString);
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