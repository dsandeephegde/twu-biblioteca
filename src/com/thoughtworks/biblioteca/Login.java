package com.thoughtworks.biblioteca;

public class Login implements MenuItem {

    private View view;
    private UserAccount userAccount;

    public Login(View view, UserAccount userAccount) {
        this.view = view;
        this.userAccount = userAccount;
    }

    @Override
    public void performOperation() {
        String userName = view.input();
        String password = view.input();
        userAccount.authenticateUser(userName, password);
    }
}