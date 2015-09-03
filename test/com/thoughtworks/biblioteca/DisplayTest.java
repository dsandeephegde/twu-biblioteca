package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class DisplayTest {
    @Test
    public void shouldReturnWelcomeMessage() {
        Display display = new Display();

        assertEquals("Welcome to Biblioteca", display.Welcome());
    }
}