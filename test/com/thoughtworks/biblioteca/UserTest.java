package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldBeEqualWhenLibraryNumbersAreEqual() {
        User user1 = new User("111-1111", "blah123");
        User user2 = new User("111-1111", "blahblah");
        assertEquals(user1, user2);
    }

    @Test
    public void shouldBeEqualForSameObjects() {
        User user = new User("111-1111", "blah123");
        assertEquals(user, user);
    }

    @Test
    public void shouldBeUnequalIfItsNull() {
        User user = new User("111-1111", "blah123");
        assertNotEquals(user, null);
    }

    @Test
    public void shouldBeUnequalIfItsComparedWithOtherObject() {
        User user = new User("111-1111", "blah123");
        assertNotEquals(user, new Object());
    }

    @Test
    public void hashShouldBeEqualIfItsEqual() {
        User user1 = new User("111-1111", "blah123");
        User user2 = new User("111-1111", "blahblah");
        assertEquals(user1.hashCode(), user2.hashCode());
    }
}