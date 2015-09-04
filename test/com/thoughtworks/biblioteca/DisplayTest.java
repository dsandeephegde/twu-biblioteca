package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

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
        BookList bookList = new BookList();
        bookList.add("Twilight");
        bookList.add("Harry Potter");
        Display display = new Display(bookList.toString());
        display.display();

        assertEquals("Twilight" + "\n" + "Harry Potter" + "\n", outContent.toString());
    }
}