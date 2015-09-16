package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserAccountTest {

    @Test
    public void shouldReturnUserForSuccessfulAuthentication() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999"));
        UserAccount userAccount = new UserAccount(users);
        assertEquals(new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999"), userAccount.authenticateUser("111-1111", "abc123"));
    }

    @Test
    public void shouldReturnInvalidUserOnUnsuccessfulAuthentication() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("111-2222", "xyz123", User.type.LIBRARIAN, "user1", "user1@gmail.com", "9999999999"));
        UserAccount userAccount = new UserAccount(users);
        assertEquals(User.type.GUEST, userAccount.authenticateUser("111-1111", "abc").getUserType());
    }
}