//Stores the Books and movies when can be checked out and books can be returned
package com.thoughtworks.biblioteca;

public class Library {

    private Books books;
    private Movies movies;

    public Library(Books books, Movies movies) {
        this.books = books;
        this.movies = movies;
    }

    public String movieList() {
        return movies.movieList();
    }

    public String bookList() {
        return books.bookList();
    }

    public Boolean checkOut(Movie movie) {
        return movies.checkOutMovie(movie);
    }

    public Boolean checkOut(Book book, User user) {
        return books.checkoutBook(book, user);
    }

    public Boolean returnBook(Book book, User user) {
        return books.returnBook(book, user);
    }

    public String checkedOutBookDetails() {
        return books.checkedOutBookDetails();
    }
}