package com.thoughtworks.biblioteca;

public class CheckedOutBookDetails implements MenuItem {

    private Library library;
    private View view;

    public CheckedOutBookDetails(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void performOperation() {
        String checkedOutBookDetails = library.checkedOutBookDetails();
        view.output(checkedOutBookDetails);
    }
}
