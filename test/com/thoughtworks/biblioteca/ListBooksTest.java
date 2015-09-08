package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksTest {

    @Test
    public void shouldCallListBook() {
        Library library = mock(Library.class);
        ListBooks listBooks = new ListBooks(library);
        listBooks.performOperation();
        verify(library).displayBookList();
    }
}