package com.thoughtworks.biblioteca;

public class CheckOutMovie implements MenuItem {
    private Library library;
    private View view;

    public CheckOutMovie(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void performOperation() {
        view.output("Enter the Movie name\n");
    }
}
