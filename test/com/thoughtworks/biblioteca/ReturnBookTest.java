package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnBookTest {

    @Test
    public void shouldCallReturnBook() {
        Library library = mock(Library.class);
        Input input = mock(Input.class);
        ReturnBook returnBook = new ReturnBook(library, input);
        returnBook.performOperation();
        verify(input).getInput();
        verify(library).returnBook(input.getInput());
    }

    @Test
    public void shouldDisplayThankYouForSuccessfulReturn() {
        Library library = mock(Library.class);
        Input input = mock(Input.class);
        when(library.returnBook(input.getInput())).thenReturn(true);
        ReturnBook returnBook = new ReturnBook(library, input);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        returnBook.performOperation();

        assertEquals("Thank you for returning the book\n", outContent.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldDisplayNotValidBookForUnsuccessfulReturn() {
        Library library = mock(Library.class);
        Input input = mock(Input.class);
        when(library.returnBook(input.getInput())).thenReturn(false);
        ReturnBook returnBook = new ReturnBook(library, input);
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        returnBook.performOperation();

        assertEquals("That is not a valid book to return\n", outContent.toString());
        System.setOut(System.out);
    }
}