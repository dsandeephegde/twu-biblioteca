package com.thoughtworks.biblioteca;

public class UserDetails implements MenuItem {
    private Session session;
    private View view;

    public UserDetails(Session session, View view) {
        this.session = session;
        this.view = view;
    }

    @Override
    public void performOperation() {
        User user = session.getCurrentUser();
        user.displayDetails(view);
    }
}
