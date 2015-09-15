package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void shouldReturnStringInACorrectFormatDisplayBookList() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies, view);

        library.displayBookList();

        verify(view).output(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40d\n%-40s%-40s%-40d\n", "Book Name", "Author", "Year Published", "Twilight", "Stephenie Meyer", 2005, "Harry Potter", "J.K. Rowling", 2002));
    }

    @Test
    public void shouldNotReturnWrongFormatDisplayBookList() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies, view);

        library.displayBookList();

        verify(view, never()).output(String.format("%-40s%-40s%-40d%-40s%-40s%-40d", "Twilight", "Stephenie Meyer", 2005, "Harry Potter", "J.K. Rowling", 2002));
    }

    @Test
    public void shouldCheckOutBookFromLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies, view);
        assertEquals(true, library.checkoutBook("Harry Potter"));
    }

    @Test
    public void shouldNotCheckOutBookFromLibraryIfNotPresent() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies, view);
        assertEquals(false, library.checkoutBook("Harry Potter 3"));
    }

    @Test
    public void shouldNotCheckOutBookIfAlreadyCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies, view);
        library.checkoutBook("Harry Potter");
        assertEquals(false, library.checkoutBook("Harry Potter"));
    }

    @Test
    public void shouldReturnBookToLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies, view);
        library.checkoutBook("Harry Potter");
        assertEquals(true, library.returnBook("Harry Potter"));
    }

    @Test
    public void shouldNotReturnBookToLibraryIfNotALibraryBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies, view);
        library.checkoutBook("Harry Potter");
        assertEquals(false, library.returnBook("Harry Potter 3"));
    }

    @Test
    public void shouldNotReturnBookToLibraryIfAlreadyAvailable() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies, view);
        assertEquals(false, library.returnBook("Harry Potter"));
    }

    @Test
    public void shouldReturnStringInACorrectFormatDisplayMovieList() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies, view);

        library.displayMovieList();

        verify(view).output(String.format("%-40s%-40s%-40s%-40s\n%-40s%-40d%-40s%-40s\n", "Movie Name", "Year", "Director", "Rating", "Bahubali", 2015, "S S Rajamouli", "9"));
    }

    @Test
    public void shouldCheckOutIfMovieAvailable() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies, view);

        assertEquals(true, library.checkOutMovie("Bahubali"));
    }

    @Test
    public void shouldNotCheckOutIfMovieNotAvailable() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies, view);

        assertEquals(false, library.checkOutMovie("Bahubali 2"));
    }
}