package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class CheckOutBookTest {

    @Test
    public void shouldCallCheckOut() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(session.getCurrentUser()).thenReturn(user);
        when(view.input()).thenReturn("book");
        Book book = new Book(view.input(), null, 0);
        CheckOutBook checkOutBook = new CheckOutBook(library, view, session);
        checkOutBook.performOperation();
        verify(library).checkOut(book, user);
    }

    @Test
    public void shouldDisplayThankYouForSuccessfulCheckout() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(session.getCurrentUser()).thenReturn(user);
        when(view.input()).thenReturn("book");
        Book book = new Book(view.input(), null, 0);
        when(library.checkOut(book, user)).thenReturn(true);
        CheckOutBook checkOutBook = new CheckOutBook(library, view, session);

        checkOutBook.performOperation();

        verify(view).output("Thank you! Enjoy the book\n");
    }

    @Test
    public void shouldDisplayNotAvailableForUnsuccessfulCheckout() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(view.input()).thenReturn("book");
        Book book = new Book(view.input(), null, 0);
        when(library.checkOut(book, user)).thenReturn(false);
        CheckOutBook checkOutBook = new CheckOutBook(library, view, session);

        checkOutBook.performOperation();

        verify(view).output("That book is not available\n");
    }

    @Test
    public void shouldDisplayEnterBookNameInitially() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        Session session = mock(Session.class);
        CheckOutBook checkOutBook = new CheckOutBook(library, view, session);

        checkOutBook.performOperation();

        verify(view).output("Enter the Book Name\n");
    }
}