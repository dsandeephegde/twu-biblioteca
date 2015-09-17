package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListMoviesTest {

    @Test
    public void shouldCallListMovie() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        ListMovies listMovies = new ListMovies(library, view);
        listMovies.performOperation();
        verify(library).movieList();
    }

    @Test
    public void shouldDisplayMovieList() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        ListMovies listMovies = new ListMovies(library, view);
        listMovies.performOperation();
        verify(view).output(library.movieList());
    }
}