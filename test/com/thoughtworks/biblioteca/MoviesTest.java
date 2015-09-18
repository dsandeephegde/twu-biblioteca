package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;

public class MoviesTest {

    @Test
    public void shouldReturnStringInACorrectFormatDisplayMovieList() {
        ArrayList<Movie> moviesList = new ArrayList<>();
        moviesList.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        Movies movies = new Movies(moviesList);

        assertEquals(String.format("%-40s%-40s%-40s%-40s\n%-40s%-40d%-40s%-40s\n", "Movie Name", "Year", "Director", "Rating", "Bahubali", 2015, "S S Rajamouli", "9"), movies.movieList());
    }

    @Test
    public void shouldCheckOutIfMovieAvailable() {
        ArrayList<Movie> moviesList = new ArrayList<>();
        Movie movie = new Movie("Bahubali", 2015, "S S Rajamouli", "9");
        moviesList.add(movie);
        Movies movies = new Movies(moviesList);

        assertEquals(true, movies.checkOutMovie(movie));
    }

    @Test
    public void shouldNotCheckOutIfMovieNotAvailable() {
        ArrayList<Movie> moviesList = new ArrayList<>();
        Movie movie = new Movie("Bahubali", 2015, "S S Rajamouli", "9");
        moviesList.add(movie);
        Movies movies = new Movies(moviesList);
        Movie movie1 = new Movie("Bahubali 2", 2016, "S S Rajamouli", "unrated");

        assertEquals(false, movies.checkOutMovie(movie1));
    }
}