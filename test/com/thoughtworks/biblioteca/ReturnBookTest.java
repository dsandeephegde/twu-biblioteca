package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ReturnBookTest {

    @Test
    public void shouldCallReturnBook() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(session.getCurrentUser()).thenReturn(user);
        when(view.input()).thenReturn("book");
        Book book = new Book(view.input(), null, 0);
        ReturnBook returnBook = new ReturnBook(library, view, session);

        returnBook.performOperation();

        verify(library).returnBook(book, user);
    }

    @Test
    public void shouldDisplayThankYouForSuccessfulReturn() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(view.input()).thenReturn("book");
        Book book = new Book(view.input(), null, 0);
        when(session.getCurrentUser()).thenReturn(user);
        when(library.returnBook(book, user)).thenReturn(true);
        ReturnBook returnBook = new ReturnBook(library, view, session);

        returnBook.performOperation();

        verify(view).output("Thank you for returning the book\n");
    }

    @Test
    public void shouldDisplayNotValidBookForUnsuccessfulReturn() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(view.input()).thenReturn("book");
        Book book = new Book(view.input(), null, 0);
        when(library.returnBook(book, user)).thenReturn(false);
        ReturnBook returnBook = new ReturnBook(library, view, session);

        returnBook.performOperation();

        verify(view).output("That is not a valid book to return\n");
    }

    @Test
    public void shouldDisplayEnterBookNameInitially() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        Session session = mock(Session.class);
        ReturnBook returnBook = new ReturnBook(library, view, session);

        returnBook.performOperation();

        verify(view).output("Enter the Book Name\n");
    }
}