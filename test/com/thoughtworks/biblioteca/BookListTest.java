package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void shouldAddToBookListOnAdd() {
        BookList bookList = new BookList();
        bookList.add("Harry Potter");

        assertEquals("Harry Potter\n", bookList.toString());
    }

    @Test
    public void shouldReturnStringInCorrectFormat() {
        BookList bookList = new BookList();
        bookList.add("Harry Potter");
        bookList.add("Twilight");

        assertEquals("Harry Potter\nTwilight\n", bookList.toString());
    }
}