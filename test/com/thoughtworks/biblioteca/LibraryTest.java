package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void shouldReturnStringInACorrectFormatDisplayBookList() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies);

        assertEquals(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40d\n%-40s%-40s%-40d\n", "Book Name", "Author", "Year Published", "Twilight", "Stephenie Meyer", 2005, "Harry Potter", "J.K. Rowling", 2002), library.bookList());
    }

    @Test
    public void shouldCheckOutBookFromLibraryIfAvailable() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        User user = mock(User.class);
        Library library = new Library(books, movies);
        assertEquals(true, library.checkoutBook("Harry Potter", user));
    }

    @Test
    public void shouldNotCheckOutBookFromLibraryIfNotPresent() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        User user = mock(User.class);
        Library library = new Library(books, movies);
        assertEquals(false, library.checkoutBook("Harry Potter 3", user));
    }

    @Test
    public void shouldNotCheckOutBookIfAlreadyCheckedOut() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        User user = mock(User.class);
        Library library = new Library(books, movies);
        library.checkoutBook("Harry Potter", user);
        assertEquals(false, library.checkoutBook("Harry Potter", user));
    }

    @Test
    public void shouldReturnBookToLibrary() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        User user = mock(User.class);
        Library library = new Library(books, movies);
        library.checkoutBook("Harry Potter", user);
        assertEquals(true, library.returnBook("Harry Potter", user));
    }

    @Test
    public void shouldNotReturnBookToLibraryIfNotALibraryBook() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        User user = mock(User.class);
        Library library = new Library(books, movies);
        library.checkoutBook("Harry Potter", user);
        assertEquals(false, library.returnBook("Harry Potter 3", user));
    }

    @Test
    public void shouldNotReturnBookToLibraryIfAlreadyAvailable() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies);
        User user = mock(User.class);
        assertEquals(false, library.returnBook("Harry Potter", user));
    }

    @Test
    public void shouldNotReturnBookToLibraryForADifferentUser() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies);
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        library.checkoutBook("Twilight", user2);
        library.checkoutBook("Harry Potter", user1);
        assertEquals(false, library.returnBook("Harry Potter", user2));
    }

    @Test
    public void shouldReturnBookForSameUser() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies);
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        library.checkoutBook("Harry Potter", user1);
        library.checkoutBook("Twilight", user2);
        assertEquals(true, library.returnBook("Harry Potter", user1));
    }

    @Test
    public void shouldReturnStringInACorrectFormatDisplayMovieList() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies);

        assertEquals(String.format("%-40s%-40s%-40s%-40s\n%-40s%-40d%-40s%-40s\n", "Movie Name", "Year", "Director", "Rating", "Bahubali", 2015, "S S Rajamouli", "9"), library.movieList());
    }

    @Test
    public void shouldCheckOutIfMovieAvailable() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies);

        assertEquals(true, library.checkOutMovie("Bahubali"));
    }

    @Test
    public void shouldNotCheckOutIfMovieNotAvailable() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies);

        assertEquals(false, library.checkOutMovie("Bahubali 2"));
    }

    @Test
    public void shouldReturnCheckedOutBookDetails() {
        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<>();
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        View view = mock(View.class);
        Library library = new Library(books, movies);
        User user = new User("111-2222", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        library.checkoutBook("Twilight", user);
        assertEquals(String.format("\nBook: \n%-40s%-40s%-40d\nCustomer: \n%-40s%-40s\n%-40s%-40s\n%-40s%-40s\n%-40s%-40s\n\n", "Twilight", "Stephenie Meyer", 2005, "library Number", "111-2222", "Name", "user1", "Email Address", "user1@gmail.com", "Phone Number", "9999999999"), library.checkedOutBookDetails());
    }
}