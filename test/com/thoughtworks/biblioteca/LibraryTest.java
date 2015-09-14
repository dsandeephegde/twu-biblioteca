package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void shouldReturnStringInACorrectFormat() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        View view = mock(View.class);
        Library library = new Library(books, view);

        library.displayBookList();

        verify(view).output(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40d\n%-40s%-40s%-40d\n", "Book Name", "Author", "Year Published", "Twilight", "Stephenie Meyer", 2005, "Harry Potter", "J.K. Rowling", 2002));
    }

    @Test
    public void shouldNotReturnWrongFormat() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        View view = mock(View.class);
        Library library = new Library(books, view);

        library.displayBookList();

        verify(view, never()).output(String.format("%-40s%-40s%-40d%-40s%-40s%-40d", "Twilight", "Stephenie Meyer", 2005, "Harry Potter", "J.K. Rowling", 2002));
    }

    @Test
    public void shouldCheckOutBookFromLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        View view = mock(View.class);
        Library library = new Library(books, view);
        assertEquals(true, library.checkoutBook("Harry Potter"));
    }

    @Test
    public void shouldNotCheckOutBookFromLibraryIfNotPresent() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        View view = mock(View.class);
        Library library = new Library(books, view);
        assertEquals(false, library.checkoutBook("Harry Potter 3"));
    }

    @Test
    public void shouldNotCheckOutBookIfAlreadyCheckedOut() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        View view = mock(View.class);
        Library library = new Library(books, view);
        library.checkoutBook("Harry Potter");
        assertEquals(false, library.checkoutBook("Harry Potter"));
    }

    @Test
    public void shouldReturnBookToLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        View view = mock(View.class);
        Library library = new Library(books, view);
        library.checkoutBook("Harry Potter");
        assertEquals(true, library.returnBook("Harry Potter"));
    }

    @Test
    public void shouldNotReturnBookToLibraryIfNotALibraryBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        View view = mock(View.class);
        Library library = new Library(books, view);
        library.checkoutBook("Harry Potter");
        assertEquals(false, library.returnBook("Harry Potter 3"));
    }

    @Test
    public void shouldNotReturnBookToLibraryIfAlreadyAvailable() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        View view = mock(View.class);
        Library library = new Library(books, view);
        assertEquals(false, library.returnBook("Harry Potter"));
    }
}