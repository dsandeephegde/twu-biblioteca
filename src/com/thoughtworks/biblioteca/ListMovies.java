//Lists the Movies Available in the Library
package com.thoughtworks.biblioteca;

public class ListMovies implements MenuItem {

    private Library library;
    private View view;

    public ListMovies(Library library, View view) {
        this.library = library;
        this.view = view;
    }

    @Override
    public void performOperation() {
        String movieList = library.movieList();
        view.output(movieList);
    }
}
