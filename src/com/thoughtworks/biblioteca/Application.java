//It has main method of application which starts the application
package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }

    public void start() {
        PrintStream printStream = new PrintStream(System.out);
        Scanner scanner = new Scanner(System.in);
        View view = new View(scanner, printStream);

        view.output("Welcome to Biblioteca\n");

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        ArrayList<Movie> movies = new ArrayList<Movie>();
        movies.add(new Movie("Bahubali", "S S Rajamouli", "9"));
        Library library = new Library(books, movies, view);

        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("1. List Books");
        menuItems.add("2. Exit");
        menuItems.add("3. CheckOut");
        menuItems.add("4. Return");
        Menu menu = new Menu(menuItems, library, view);

        Controller controller = new Controller(view, menu);
        controller.run();
    }
}