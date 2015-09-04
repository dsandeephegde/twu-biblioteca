package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class DisplayTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void shouldPrintWelcomeMessage() {
        Display display = new Display(new ArrayList<String>());
        display.display("Welcome to Biblioteca");
        assertEquals("Welcome to Biblioteca\n", outContent.toString());
    }

    @Test
    public void shouldPrintListOfBooks() {
        ArrayList<String> books = new ArrayList<String>();
        books.add("Book1");
        books.add("Book2");
        Display display = new Display(books);
        display.displayBooks();

        assertEquals("Book1\nBook2\n", outContent.toString());
    }
}