package com.thoughtworks.biblioteca;

import static java.lang.System.*;

public class Quit implements MenuItem {

    @Override
    public void performOperation() {
        exit(0);
    }
}
