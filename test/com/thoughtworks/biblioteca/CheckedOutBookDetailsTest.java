package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class CheckedOutBookDetailsTest {

    @Test
    public void shouldDisplayCheckedOutBookDetails() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        CheckedOutBookDetails checkedOutBookDetails = new CheckedOutBookDetails(library, view);
        checkedOutBookDetails.performOperation();

        verify(view).output(library.checkedOutBookDetails());
    }

    @Test
    public void shouldCallCheckedOutBookDetailsOfLibrary() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        CheckedOutBookDetails checkedOutBookDetails = new CheckedOutBookDetails(library, view);
        checkedOutBookDetails.performOperation();

        verify(library).checkedOutBookDetails();
    }
}