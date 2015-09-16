package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import static org.mockito.Mockito.*;

public class ControllerTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldExitFromWhileForGuestMenu() {
        View view = mock(View.class);
        Menu menu = mock(Menu.class);
        User user = mock(User.class);
        Session session = mock(Session.class);
        MenuFactory menuFactory = mock(MenuFactory.class);
        when(session.getCurrentUser()).thenReturn(user);
        when(menuFactory.configureMenu(session.getCurrentUser())).thenReturn(menu);
        when(user.getUserType()).thenReturn(User.type.GUEST);
        when(menu.selectMenuItem(view.input())).thenReturn(new Quit());
        Controller controller = new Controller(view, menuFactory, session);

        exit.expectSystemExit();
        controller.run();
    }

    @Test
    public void shouldExitFromWhileForCustomerMenu() {
        View view = mock(View.class);
        Menu menu = mock(Menu.class);
        User user = mock(User.class);
        Session session = mock(Session.class);
        MenuFactory menuFactory = mock(MenuFactory.class);
        when(session.getCurrentUser()).thenReturn(user);
        when(menuFactory.configureMenu(session.getCurrentUser())).thenReturn(menu);
        when(user.getUserType()).thenReturn(User.type.CUSTOMER);
        when(menu.selectMenuItem(view.input())).thenReturn(new Quit());
        Controller controller = new Controller(view, menuFactory, session);

        exit.expectSystemExit();
        controller.run();
    }

    @Test
    public void shouldExitFromWhileForLibrarianMenu() {
        View view = mock(View.class);
        Menu menu = mock(Menu.class);
        User user = mock(User.class);
        Session session = mock(Session.class);
        MenuFactory menuFactory = mock(MenuFactory.class);
        when(session.getCurrentUser()).thenReturn(user);
        when(menuFactory.configureMenu(session.getCurrentUser())).thenReturn(menu);
        when(user.getUserType()).thenReturn(User.type.LIBRARIAN);
        when(menu.selectMenuItem(view.input())).thenReturn(new Quit());
        Controller controller = new Controller(view, menuFactory, session);

        exit.expectSystemExit();
        controller.run();
    }
}