package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class DisplayTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(System.out);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        Display display = new Display("Welcome to Biblioteca\n");
        display.display();
        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }

    @Test
    public void shouldPrintListOfBooks() {
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        BookList bookList = new BookList(books);
        Display display = new Display(bookList.toString());
        display.display();

        assertEquals("Twilight\t" + "Stephenie Meyer\t" + 2005 + "\n" + "Harry Potter\t" + "J.K. Rowling\t" + 2002 + "\n", outContent.toString());
    }
}