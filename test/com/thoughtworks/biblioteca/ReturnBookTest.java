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
        View view = mock(View.class);
        ReturnBook returnBook = new ReturnBook(library, view);

        returnBook.performOperation();

        verify(library).returnBook(view.input());
    }

    @Test
    public void shouldDisplayThankYouForSuccessfulReturn() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        when(library.returnBook(view.input())).thenReturn(true);
        ReturnBook returnBook = new ReturnBook(library, view);

        returnBook.performOperation();

        verify(view).output("Thank you for returning the book\n");
    }

    @Test
    public void shouldDisplayNotValidBookForUnsuccessfulReturn() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        when(library.returnBook(view.input())).thenReturn(false);
        ReturnBook returnBook = new ReturnBook(library, view);

        returnBook.performOperation();

        verify(view).output("That is not a valid book to return\n");
    }
}