package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class ListBooksTest {

    @Test
    public void shouldCallListBook() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        ListBooks listBooks = new ListBooks(library, view);
        listBooks.performOperation();
        verify(library).bookList();
    }

    @Test
    public void shouldDisplayBookList() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        ListBooks listBooks = new ListBooks(library, view);
        listBooks.performOperation();
        verify(view).output(library.bookList());
    }
}