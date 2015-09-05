package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void shouldReturnStringInCorrectFormat() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        BookList bookList = new BookList(books);
        assertEquals("Twilight\t" + "Stephenie Meyer\t" + 2005 + "\n" + "Harry Potter\t" + "J.K. Rowling\t" + 2002 + "\n", bookList.toString());
    }
}