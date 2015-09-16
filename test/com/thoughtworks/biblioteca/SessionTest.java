package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class SessionTest {

    @Test
    public void shouldGetCorrectSessionUser() {
        User user = new User("111-1111", "abc", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        Session session = new Session(user);
        assertEquals(user, session.getCurrentUser());
    }

    @Test
    public void shouldSetCorrectSessionUser() {
        User user = new User("111-1111", "abc", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        Session session = new Session(new User("", "", User.type.GUEST, "user1", "user1@gmail.com", "9999999999"));
        session.setCurrentUser(user);
        assertEquals(user, session.getCurrentUser());
    }
}