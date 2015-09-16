package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class LogoutTest {

    @Test
    public void shouldSetTheSession() {
        Session session = mock(Session.class);
        Logout logout = new Logout(session);
        logout.performOperation();
        verify(session).setCurrentUser(new User("111-0000", "abc", User.type.GUEST, "user1", "user1@gmail.com", "9999999999"));
    }
}