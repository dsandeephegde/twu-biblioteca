package com.thoughtworks.biblioteca;

public class CheckOutBook implements MenuItem {

    private Library library;
    private Input input;

    public CheckOutBook(Library library,Input input) {
        this.library = library;
        this.input = input;
    }

    @Override
    public void performOperation() {
        String bookName = input.getInput();
        library.checkout(bookName);
    }
}