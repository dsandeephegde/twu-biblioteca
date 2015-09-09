package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
}