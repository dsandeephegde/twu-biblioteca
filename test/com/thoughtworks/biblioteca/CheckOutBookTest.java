package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutBookTest {

    @Test
    public void shouldCallCheckOut() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        CheckOutBook checkOutBook = new CheckOutBook(library, view);
        checkOutBook.performOperation();
        verify(view).input();
        verify(library).checkoutBook(view.input());
    }

    @Test
    public void shouldDisplayThankYouForSuccessfulCheckout() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        when(library.checkoutBook(view.input())).thenReturn(true);
        CheckOutBook checkOutBook = new CheckOutBook(library, view);

        checkOutBook.performOperation();

        verify(view).output("Thank you! Enjoy the book\n");
    }

    @Test
    public void shouldDisplayNotAvailableForUnsuccessfulCheckout() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        when(library.checkoutBook(view.input())).thenReturn(false);
        CheckOutBook checkOutBook = new CheckOutBook(library, view);

        checkOutBook.performOperation();

        verify(view).output("That book is not available\n");
    }

    @Test
    public void shouldDisplayEnterBookNameInitially() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        CheckOutBook checkOutBook = new CheckOutBook(library, view);

        checkOutBook.performOperation();

        verify(view).output("Enter the Book Name\n");
    }
}