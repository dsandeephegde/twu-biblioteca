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
        Input input = mock(Input.class);
        CheckOutBook checkOutBook = new CheckOutBook(library, input);
        checkOutBook.performOperation();
        verify(input).getInput();
        verify(library).checkout(input.getInput());
    }

    @Test
    public void shouldDisplayThankYouForSuccessfulReturn() {
        Library library = mock(Library.class);
        Input input = mock(Input.class);
        when(library.checkout(input.getInput())).thenReturn(true);
        CheckOutBook checkOutBook = new CheckOutBook(library, input);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        checkOutBook.performOperation();

        assertEquals("Thank you! Enjoy the book\n", outContent.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayNotAvailableForUnsuccessfulReturn() {
        Library library = mock(Library.class);
        Input input = mock(Input.class);
        when(library.checkout(input.getInput())).thenReturn(false);
        CheckOutBook checkOutBook = new CheckOutBook(library, input);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        checkOutBook.performOperation();

        assertEquals("That book is not available\n", outContent.toString());
        System.setOut(System.out);
    }
}