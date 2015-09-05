package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldReturnCorrectToString() {
        Book book = new Book("Twilight", "Stephenie Meyer", 2005);
        assertEquals("Twilight\t" + "Stephenie Meyer\t" + 2005, book.toString());
    }
}