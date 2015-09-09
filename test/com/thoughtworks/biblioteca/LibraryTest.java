package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LibraryTest {

    @Test
    public void shouldReturnStringInACorrectFormat() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        View view = mock(View.class);
        Library library = new Library(books, view);

        assertEquals("Book Name\t" + "Author\t" + "Year Published\n" + "Twilight\t" + "Stephenie Meyer\t" + 2005 + "\n" + "Harry Potter\t" + "J.K. Rowling\t" + 2002 + "\n", library.toString());
    }

    @Test
    public void shouldNotReturnWrongFormat() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        View view = mock(View.class);
        Library library = new Library(books, view);

        assertNotEquals("Twilight\t" + "Stephenie Meyer\t" + 2005 + "\n" + "Harry Potter\t" + "J.K. Rowling\t" + 2002 + "\n", library.toString());
    }

    @Test
    public void displayBookListShouldCallOutput() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        View view = mock(View.class);
        Library library = new Library(books, view);

        library.displayBookList();

        verify(view).output("Book Name\t" + "Author\t" + "Year Published\n" + "Twilight\t" + "Stephenie Meyer\t" + 2005 + "\n" + "Harry Potter\t" + "J.K. Rowling\t" + 2002 + "\n");
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