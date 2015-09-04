package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class BookListTest {

    @Test
    public void shouldReturnStringInCorrectFormat() {
        ArrayList<String> books = new ArrayList<String>();
        books.add("Harry Potter");
        books.add("Twilight");
        BookList bookList = new BookList(books);
        assertEquals("Harry Potter\nTwilight\n", bookList.toString());
    }
}