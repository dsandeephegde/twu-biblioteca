//It is Menu Item which does return book operation
package com.thoughtworks.biblioteca;

public class ReturnBook implements MenuItem {

    private Library library;
    private View view;
    private Session session;

    public ReturnBook(Library library, View view, Session session) {
        this.library = library;
        this.view = view;
        this.session = session;
    }

    @Override
    public void performOperation() {
        view.output("Enter the Book Name\n");
        String bookName = view.input();
        if(library.returnBook(bookName, session.getCurrentUser()))
            view.output("Thank you for returning the book\n");
        else
            view.output("That is not a valid book to return\n");
    }
}