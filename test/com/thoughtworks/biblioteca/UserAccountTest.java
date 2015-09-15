package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class UserAccountTest {

    @Test
    public void shouldReturnUserForSuccessfulAuthentication() {
        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("111-1111", "abc123", User.type.CUSTOMER));
        UserAccount userAccount = new UserAccount(users);
        assertEquals(new User("111-1111", "abc123", User.type.CUSTOMER), userAccount.authenticateUser("111-1111", "abc123"));
    }
}