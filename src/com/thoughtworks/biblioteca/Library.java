//Stores the List of Books which can be checked out or returned
package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Library {

    private ArrayList<Book> availableBooks;
    private HashMap<Book, User> checkOutBooksHash = new HashMap<>();
    private ArrayList<Movie> movies;

    public Library(ArrayList<Book> books, ArrayList<Movie> movies) {
        this.availableBooks = books;
        this.movies = movies;
    }

    public String movieList() {
        String listMovieString = "";
        listMovieString += String.format("%-40s%-40s%-40s%-40s", "Movie Name", "Year", "Director", "Rating") + "\n";
        for (Movie movie : movies) {
            listMovieString += movie.toString() + "\n";
        }
        return listMovieString;
    }

    public String bookList() {
        String listBookString = "";
        listBookString += String.format("%-40s%-40s%-40s", "Book Name", "Author", "Year Published") + "\n";
        for (Book book : availableBooks) {
            listBookString += book.toString() + "\n";
        }
        return listBookString;
    }

    public Boolean checkOutMovie(String movieName) {
        Movie searchableMovie = new Movie(movieName, 0, null, null);
        for (Movie movie : movies) {
            if (movie.equals(searchableMovie)) {
                movies.remove(movie);
                return true;
            }
        }
        return false;
    }

    public Boolean checkoutBook(String bookName, User user) {
        Book searchableBook = new Book(bookName, null, 0);
        for (Book book : availableBooks) {
            if (book.equals(searchableBook)) {
                checkOutBooksHash.put(book, user);
                availableBooks.remove(book);
                return true;
            }
        }
        return false;
    }

    public Boolean returnBook(String bookName, User user) {
        Book searchableBook = new Book(bookName, null, 0);
        User searchedUser = checkOutBooksHash.get(searchableBook);
        for (Book book : checkOutBooksHash.keySet())
            if (book.equals(searchableBook) && user == searchedUser) {
                availableBooks.add(book);
                checkOutBooksHash.remove(book);
                return true;
            }
        return false;
    }

    public String checkedOutBookDetails() {
        String checkedOutBookDetails = "";
        Set set = checkOutBooksHash.entrySet();
        for (Object aSet : set) {
            Map.Entry entry = (Map.Entry) aSet;
            checkedOutBookDetails += "\nBook: \n" + entry.getKey().toString() + "\nCustomer: \n" + ((User)entry.getValue()).userDetails() + "\n";
        }
        return checkedOutBookDetails;
    }
}