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
        if(library.checkoutBook(bookName)) {
            Display display = new Display("Thank you! Enjoy the book\n");
            display.display();
        } else {
            Display display = new Display("That book is not available\n");
            display.display();
        }
    }
}