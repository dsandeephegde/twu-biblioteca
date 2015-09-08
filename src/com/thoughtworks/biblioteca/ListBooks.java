package com.thoughtworks.biblioteca;

public class ListBooks implements MenuItem {

    private Library library;

    ListBooks(Library library) {
        this.library = library;
    }

    @Override
    public void performOperation() {
        library.displayBookList();
    }
}
