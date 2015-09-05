package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }

    public void start() {
        String welcome = "Welcome to Biblioteca\n";
        Display displayWelcome = new Display(welcome);
        displayWelcome.display();
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. Book List");
        Menu menu = new Menu(options);
        menu.display();
        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        BookList bookList = new BookList(books);
        Display displayBookList = new Display(bookList.toString());
        displayBookList.display();
    }
}
