package com.thoughtworks.biblioteca;

import com.sun.org.apache.bcel.internal.generic.MONITORENTER;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void shouldDisplayBookList() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        Library library = new Library(books, movies);
        library.bookList();
        verify(books).bookList();
    }

    @Test
    public void shouldDisplayMovieList() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        Library library = new Library(books, movies);
        library.movieList();
        verify(movies).movieList();
    }

    @Test
    public void shouldCheckoutMovie() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        Movie movie = mock(Movie.class);
        Library library = new Library(books, movies);
        library.checkOut(movie);
        verify(movies).checkOutMovie(movie);
    }

    @Test
    public void shouldCheckOutBook() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        Library library = new Library(books, movies);
        Book book = mock(Book.class);
        User user = mock(User.class);
        library.checkOut(book, user);
        verify(books).checkoutBook(book, user);
    }

    @Test
    public void shouldReturnBook() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        Library library = new Library(books, movies);
        Book book = mock(Book.class);
        User user = mock(User.class);
        library.returnBook(book, user);
        verify(books).returnBook(book, user);
    }

    @Test
    public void shouldReturnCheckedOutBookDetails() {
        Books books = mock(Books.class);
        Movies movies = mock(Movies.class);
        Library library = new Library(books, movies);
        library.checkedOutBookDetails();
        verify(books).checkedOutBookDetails();
    }
}