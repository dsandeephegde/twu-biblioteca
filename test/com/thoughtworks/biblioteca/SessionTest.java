package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class SessionTest {

    @Test
    public void shouldGetCorrectSessionUser() {
        User user = new User("111-1111", "abc", User.type.CUSTOMER);
        Session session = new Session(user);
        assertEquals(user, session.getCurrentUser());
    }

    @Test
    public void shouldSetCorrectSessionUser() {
        User user = new User("111-1111", "abc", User.type.CUSTOMER);
        Session session = new Session(new User("", "", User.type.INVALID));
        session.setCurrentUser(user);
        assertEquals(user, session.getCurrentUser());
    }
}