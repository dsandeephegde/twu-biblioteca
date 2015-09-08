package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

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
}