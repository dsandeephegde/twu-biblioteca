package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    @Test
    public void shouldBeEqualWhenLibraryNumbersAreEqual() {
        User user1 = new User("111-1111", "abc123", User.type.CUSTOMER);
        User user2 = new User("111-1111", "abcabc", User.type.CUSTOMER);
        assertEquals(user1, user2);
    }

    @Test
    public void shouldBeEqualForSameObjects() {
        User user = new User("111-1111", "abc123", User.type.CUSTOMER);
        assertEquals(user, user);
    }

    @Test
    public void shouldBeUnequalIfItsNull() {
        User user = new User("111-1111", "abc123", User.type.CUSTOMER);
        assertNotEquals(user, null);
    }

    @Test
    public void shouldBeUnequalIfItsComparedWithOtherObject() {
        User user = new User("111-1111", "abc123", User.type.CUSTOMER);
        assertNotEquals(user, new Object());
    }

    @Test
    public void hashShouldBeEqualIfItsEqual() {
        User user1 = new User("111-1111", "abc123", User.type.CUSTOMER);
        User user2 = new User("111-1111", "abcabc", User.type.CUSTOMER);
        assertEquals(user1.hashCode(), user2.hashCode());
    }
    
    @Test
    public void shouldAuthenticateIfPasswordIsCorrectForASameUser() {
        User user1 = new User("111-1111", "abc123", User.type.CUSTOMER);
        User user2 = new User("111-1111", "abc123", User.type.CUSTOMER);
        assertEquals(true, user1.authenticate(user2));
    }

    @Test
    public void shouldAuthenticateIfPasswordIsInCorrectForASameUser() {
        User user1 = new User("111-1111", "abc123", User.type.CUSTOMER);
        User user2 = new User("111-1111", "abcd123", User.type.CUSTOMER);
        assertEquals(false, user1.authenticate(user2));
    }

    @Test
    public void shouldAuthenticateIfPasswordIsCorrectForDifferentUser() {
        User user1 = new User("111-2222", "abc123", User.type.CUSTOMER);
        User user2 = new User("111-1111", "abc123", User.type.CUSTOMER);
        assertEquals(false, user1.authenticate(user2));
    }
}