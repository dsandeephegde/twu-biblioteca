package com.thoughtworks.biblioteca;

public class InvalidMenuItem implements MenuItem {

    @Override
    public void performOperation() {
        Display display = new Display("Select a valid option!\n");
        display.display();
    }
}