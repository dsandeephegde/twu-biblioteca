package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MenuFactoryTest {

    @Test
    public void shouldCallGuestMenuIfUserIsGuest() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(user.getUserType()).thenReturn(User.type.GUEST);
        MenuFactory menuFactory = new MenuFactory(library, view, userAccount, session);

        assertEquals(Menu.class, menuFactory.configureMenu(user).getClass());
    }

    @Test
    public void shouldCallCustomerMenuIfUserIsCustomer() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(user.getUserType()).thenReturn(User.type.CUSTOMER);
        MenuFactory menuFactory = new MenuFactory(library, view, userAccount, session);

        assertEquals(Menu.class, menuFactory.configureMenu(user).getClass());
    }

    @Test
    public void shouldCallLibrarianMenuIfUserIsLibrarian() {
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(user.getUserType()).thenReturn(User.type.LIBRARIAN);
        MenuFactory menuFactory = new MenuFactory(library, view, userAccount, session);

        assertEquals(Menu.class, menuFactory.configureMenu(user).getClass());
    }
}