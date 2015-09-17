package com.thoughtworks.biblioteca;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class UserTest {

    @Test
    public void shouldBeEqualWhenLibraryNumbersAreEqual() {
        User user1 = new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        User user2 = new User("111-1111", "abcabc", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        assertEquals(user1, user2);
    }

    @Test
    public void shouldBeEqualForSameObjects() {
        User user = new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        assertEquals(user, user);
    }

    @Test
    public void shouldBeUnequalIfItsNull() {
        User user = new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        assertNotEquals(user, null);
    }

    @Test
    public void shouldBeUnequalIfItsComparedWithOtherObject() {
        User user = new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        assertNotEquals(user, new Object());
    }

    @Test
    public void hashShouldBeEqualIfItsEqual() {
        User user1 = new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        User user2 = new User("111-1111", "abcabc", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        assertEquals(user1.hashCode(), user2.hashCode());
    }
    
    @Test
    public void shouldAuthenticateIfPasswordIsCorrectForASameUser() {
        User user1 = new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        User user2 = new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        assertEquals(true, user1.authenticate(user2));
    }

    @Test
    public void shouldAuthenticateIfPasswordIsInCorrectForASameUser() {
        User user1 = new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        User user2 = new User("111-1111", "abcd123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        assertEquals(false, user1.authenticate(user2));
    }

    @Test
    public void shouldAuthenticateIfPasswordIsCorrectForDifferentUser() {
        User user1 = new User("111-2222", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        User user2 = new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        assertEquals(false, user1.authenticate(user2));
    }

    @Test
    public void shouldOutputUserDetails() {
        User user = new User("111-2222", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        assertEquals(String.format("%-40s%-40s\n%-40s%-40s\n%-40s%-40s\n%-40s%-40s\n", "library Number", "111-2222", "Name", "user1", "Email Address", "user1@gmail.com", "Phone Number", "9999999999"), user.userDetails());
    }
}