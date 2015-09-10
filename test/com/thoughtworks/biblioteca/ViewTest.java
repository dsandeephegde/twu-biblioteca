package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;

public class ViewTest {

    @Test
    public void shouldGetInputFromConsole() {
        ByteArrayInputStream in = new ByteArrayInputStream("1".getBytes());
        System.setIn(in);
        Scanner scanner = new Scanner(System.in);
        View view = new View(scanner, new PrintStream(System.out));
        assertEquals("1", view.input());
        System.setIn(System.in);
    }

    @Test
    public void messageShouldGetPrintedToConsole() {
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        PrintStream printStream = new PrintStream(System.out);
        View view = new View(new Scanner(System.in), printStream);
        view.output("Welcome to Biblioteca\n");
        assertEquals("Welcome to Biblioteca\n", outContent.toString());
        System.setOut(System.out);
    }
}