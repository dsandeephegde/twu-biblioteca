package com.thoughtworks.biblioteca;

public class Login implements MenuItem {

    private View view;
    private UserAccount userAccount;
    private Session session;

    public Login(View view, UserAccount userAccount, Session session) {
        this.view = view;
        this.userAccount = userAccount;
        this.session = session;
    }

    @Override
    public void performOperation() {
        String libraryNumber = view.input();
        String password = view.input();
        session.setCurrentUser(userAccount.authenticateUser(libraryNumber, password));
    }
}