//It is Menu Item which does checkout book operation
package com.thoughtworks.biblioteca;

public class CheckOutBook implements MenuItem {

    private Library library;
    private View view;

    public CheckOutBook(Library library,View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void performOperation() {
        view.output("Enter the Book Name\n");
        String bookName = view.input();
        if(library.checkoutBook(bookName))
            view.output("Thank you! Enjoy the book\n");
         else
             view.output("That book is not available\n");
    }
}