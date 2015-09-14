package com.thoughtworks.biblioteca;

public class ListMovies implements MenuItem {

    private Library library;

    public ListMovies(Library library) {
        this.library = library;
    }

    @Override
    public void performOperation() {
        library.displayMovieList();
    }
}
