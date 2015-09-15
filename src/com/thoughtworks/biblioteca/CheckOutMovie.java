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
        String movieName = view.input();
        if (library.checkOutMovie(movieName))
            view.output("Thank You! Enjoy the Movie\n");
        else
            view.output("That Movie is not available\n");
    }
}