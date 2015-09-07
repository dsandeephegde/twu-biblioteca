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
}