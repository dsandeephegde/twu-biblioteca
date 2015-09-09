//It is Menu Item which does return book operation
package com.thoughtworks.biblioteca;

public class ReturnBook implements MenuItem {

    private Library library;
    private View view;

    public ReturnBook(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void performOperation() {
        String bookName = view.input();
        if(library.returnBook(bookName))
            view.output("Thank you for returning the book\n");
        else
            view.output("That is not a valid book to return\n");
    }
}
