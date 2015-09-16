package com.thoughtworks.biblioteca;

public class Logout implements MenuItem {
    private Session session;

    public Logout(Session session) {
        this.session = session;
    }

    @Override
    public void performOperation() {
        session.setCurrentUser(new User("111-0000", "abc", User.type.GUEST, "user1", "user1@gmail.com", "9999999999"));
    }
}