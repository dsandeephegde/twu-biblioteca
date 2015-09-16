package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitFromWhile() {
        View view = mock(View.class);
        Menu menu = mock(Menu.class);
        Session session = mock(Session.class);
        Controller controller = new Controller(view, menu, session);
        when(menu.selectMenuItem(view.input())).thenReturn(new Quit());

        exit.expectSystemExit();
        controller.run();
    }
}