package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldReturnCorrectFormatOfToString() {
        Movie movie = new Movie("Bahubali", "S S Rajamauli", "9");
        assertEquals(String.format("%-40s%-40s%-40s", "Bahubali", "S S Rajamauli", "9"), movie.toString());
    }
}