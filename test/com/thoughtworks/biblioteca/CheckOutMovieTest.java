package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutMovieTest {

    @Test
    public void shouldDisplayEnterMovieNameInitially() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        MenuItem menuItem = new CheckOutMovie(library, view);

        menuItem.performOperation();

        verify(view).output("Enter the Movie name\n");
    }

    @Test
    public void shouldDisplayThankYouOnSuccessfulCheckOut() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        when(library.checkOutMovie(view.input())).thenReturn(true);
        MenuItem menuItem = new CheckOutMovie(library, view);

        menuItem.performOperation();

        verify(view).output("Thank You! Enjoy the Movie\n");
    }

    @Test
    public void shouldDisplayNotAvailableOnUnsuccessfulCheckOut() {
        View view = mock(View.class);
        Library library = mock(Library.class);
        when(library.checkOutMovie(view.input())).thenReturn(false);
        MenuItem menuItem = new CheckOutMovie(library, view);

        menuItem.performOperation();

        verify(view).output("That Movie is not available\n");
    }
}