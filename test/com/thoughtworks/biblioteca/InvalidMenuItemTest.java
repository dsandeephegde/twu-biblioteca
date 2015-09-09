package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class InvalidMenuItemTest {

    @Test
    public void shouldDisplayInvalid() {
        View view = mock(View.class);
        MenuItem invalidMenuItem = new InvalidMenuItem(view);

        invalidMenuItem.performOperation();

        verify(view).output("Select a valid option!\n");
    }
}