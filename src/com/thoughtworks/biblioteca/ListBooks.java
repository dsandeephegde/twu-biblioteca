//It is Menu Item which does listing the books operation
package com.thoughtworks.biblioteca;

public class ListBooks implements MenuItem {

    private Library library;
    private View view;

    public ListBooks(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void performOperation() {
        String bookList = library.bookList();
        view.output(bookList);
    }
}
