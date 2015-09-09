package com.thoughtworks.biblioteca;

public class ReturnBook implements MenuItem {

    private Library library;
    private Input input;

    public ReturnBook(Library library, Input input) {
        this.library = library;
        this.input = input;
    }

    @Override
    public void performOperation() {
        String bookName = input.getInput();
        library.returnBook(bookName);
    }
}
