package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMoviesTest {

    @Test
    public void shouldCallListBook() {
        Library library = mock(Library.class);
        ListMovies listMovies = new ListMovies(library);
        listMovies.performOperation();
        verify(library).displayMovieList();
    }
}