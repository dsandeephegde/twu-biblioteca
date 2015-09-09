package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class LibraryTest {

    @Test
    public void shouldReturnStringInCorrectFormat() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        Library library = new Library(books);
        assertEquals("Book Name\t" + "Author\t" + "Year Published\n" + "Twilight\t" + "Stephenie Meyer\t" + 2005 + "\n" + "Harry Potter\t" + "J.K. Rowling\t" + 2002 + "\n", library.toString());
    }

    @Test
    public void shouldCheckOutBookFromLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        Library library = new Library(books);
        assertEquals(true, library.checkout("Harry Potter"));
    }

    @Test
    public void shouldNotCheckOutBookFromLibraryIfNotPresent() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        Library library = new Library(books);
        assertEquals(false, library.checkout("Harry Potter 3"));
    }

    @Test
    public void shouldReturnBookToLibrary() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        Library library = new Library(books);
        library.checkout("Harry Potter");
        assertEquals(true, library.returnBook("Harry Potter"));
    }

    @Test
    public void shouldNotReturnBookToLibraryIfNotALibraryBook() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        Library library = new Library(books);
        library.checkout("Harry Potter");
        assertEquals(false, library.returnBook("Harry Potter 3"));
    }
}