package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.*;

public class LoginTest {

    @Test
    public void shouldInputLibraryNumberAndPassword() {
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Login login = new Login(view, userAccount, session);

        login.performOperation();

        verify(view, times(2)).input();
    }

    @Test
    public void shouldDisplayEnterLibraryNumber() {
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Login login = new Login(view, userAccount, session);

        login.performOperation();

        verify(view).output("Enter Library Number\n");
    }

    @Test
    public void shouldDisplayEnterPassword() {
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Login login = new Login(view, userAccount, session);

        login.performOperation();

        verify(view).output("Enter Password\n");
    }

    @Test
    public void shouldCallAuthenticateUser() {
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Login login = new Login(view, userAccount, session);

        login.performOperation();

        verify(userAccount).authenticateUser(view.input(), view.input());
    }

    @Test
    public void shouldSetSession() {
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Login login = new Login(view, userAccount, session);

        login.performOperation();

        verify(session).setCurrentUser(userAccount.authenticateUser(view.input(), view.input()));
    }
}