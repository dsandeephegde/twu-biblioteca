package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class MovieTest {

    @Test
    public void shouldReturnCorrectFormatOfToString() {
        Movie movie = new Movie("Bahubali", 2015, "S S Rajamauli", "9");
        assertEquals(String.format("%-40s%-40d%-40s%-40s", "Bahubali", 2015, "S S Rajamauli", "9"), movie.toString());
    }

    @Test
    public void shouldReturnTrueIfMoviesHaveSameName() {
        Movie movie1 = new Movie("Bahubali", 2015, "S S Rajamauli", "9");
        Movie movie2 = new Movie("Bahubali", 2015, "S. S. Rajamauli", "9");
        assertEquals(movie1, movie2);
    }

    @Test
    public void shouldReturnFalseIfMoviesHaveDifferentName() {
        Movie movie1 = new Movie("Bahubali", 2015, "S S Rajamauli", "9");
        Movie movie2 = new Movie("Bahubali 2", 2015, "S. S. Rajamauli", "9");
        assertNotEquals(movie1, movie2);
    }

    @Test
    public void shouldReturnTrueForSameMovie() {
        Movie movie = new Movie("Bahubali", 2015, "S S Rajamauli", "9");
        assertEquals(movie, movie);
    }

    @Test
    public void shouldReturnFalseOnNullComparison() {
        Movie movie = new Movie("Bahubali", 2015, "S S Rajamauli", "9");
        assertNotEquals(movie, null);
    }

    @Test
    public void shouldReturnFalseOnComparisonWithOtherObject() {
        Movie movie = new Movie("Bahubali", 2015, "S S Rajamauli", "9");
        assertNotEquals(movie, new Object());
    }

    @Test
    public void hashShouldBeSameForEqualMovies() {
        Movie movie1 = new Movie("Bahubali", 2015, "S S Rajamauli", "9");
        Movie movie2 = new Movie("Bahubali", 2015, "S. S. Rajamauli", "9");
        assertEquals(movie1.hashCode(), movie2.hashCode());
    }
}