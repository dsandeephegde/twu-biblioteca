package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class BookTest {

    @Test
    public void shouldReturnCorrectToString() {
        Book book = new Book("Twilight", "Stephenie Meyer", 2005);
        assertEquals("Twilight\t" + "Stephenie Meyer\t" + 2005, book.toString());
    }

    @Test
    public void shouldReturnTrueForEqualNames() {
        Book book = new Book("Twilight", "Stephenie Meyer", 2005);
        assertEquals(true, book.hasName("Twilight"));
    }

    @Test
    public void shouldReturnTrueIfBooksHaveSameName() {
        Book book1 = new Book("Twilight", "Stephenie Meyer", 2005);
        Book book2 = new Book("Twilight", "Stephenie", 2006);
        assertEquals(book1, book2);
    }

    @Test
    public void shouldReturnFalseIfBooksHaveDifferentName() {
        Book book1 = new Book("Twilight", "Stephenie Meyer", 2005);
        Book book2 = new Book("Twilight 2", "Stephenie", 2006);
        assertNotEquals(book1, book2);
    }

    @Test
    public void hashShouldBeSameForEqualBooks() {
        Book book1 = new Book("Twilight", "Stephenie Meyer", 2005);
        Book book2 = new Book("Twilight", "Stephenie", 2006);
        assertEquals(book1.hashCode(), book2.hashCode());
    }
}