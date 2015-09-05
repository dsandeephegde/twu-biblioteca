package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;

public class MenuTest {

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void shouldDisplayMenuList() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        Menu menu = new Menu(options);
        System.setOut(new PrintStream(outContent));
        menu.display();
        assertEquals("1. List Books\n", outContent.toString());
        System.setOut(System.out);
    }
}