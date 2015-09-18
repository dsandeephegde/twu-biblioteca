//It is Menu Item which does checkout book operation
package com.thoughtworks.biblioteca;

public class CheckOutBook implements MenuItem {

    private Library library;
    private View view;
    private Session session;

    public CheckOutBook(Library library, View view, Session session) {
        this.library = library;
        this.view = view;
        this.session = session;
    }

    @Override
    public void performOperation() {
        view.output("Enter the Book Name\n");
        String bookName = view.input();
        Book book = new Book(bookName, null, 0);
        if(library.checkOut(book, session.getCurrentUser()))
            view.output("Thank you! Enjoy the book\n");
         else
             view.output("That book is not available\n");
    }
}