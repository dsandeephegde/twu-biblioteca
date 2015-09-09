//It is Menu Item which does listing the books operation
package com.thoughtworks.biblioteca;

public class ListBooks implements MenuItem {

    private Library library;

    public ListBooks(Library library) {
        this.library = library;
    }

    @Override
    public void performOperation() {
        library.displayBookList();
    }
}
