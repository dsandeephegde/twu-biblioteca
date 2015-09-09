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
        if(library.returnBook(bookName)) {
            Display display = new Display("Thank you for returning the book\n");
            display.display();
        } else {
            Display display = new Display("That is not a valid book to return\n");
            display.display();
        }
    }
}
