package com.thoughtworks.biblioteca;

public class Quit implements MenuItem {

    @Override
    public void performOperation() {
        System.exit(0);
    }
}
