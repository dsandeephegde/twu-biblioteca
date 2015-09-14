package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckOutMovieTest {

    @Test
    public void shouldDisplayEnterMovieNameInitially() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        MenuItem menuItem = new CheckOutMovie(library, view);
        menuItem.performOperation();

        verify(view).output("Enter the Movie name\n");
    }
}