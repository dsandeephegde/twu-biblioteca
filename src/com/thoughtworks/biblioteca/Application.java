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
        movies.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        Library library = new Library(books, movies, view);

        ArrayList<User> users = new ArrayList<User>();
        users.add(new User("111-1111", "abc123", User.type.CUSTOMER));
        users.add(new User("111-2222", "xyz123", User.type.LIBRARIAN));
        UserAccount userAccount = new UserAccount(users);

        Session session = new Session(new User("111-0000", "abc", User.type.GUEST));
        MenuFactory menuFactory = new MenuFactory(library, view, userAccount, session);
        Controller controller = new Controller(view, menuFactory, session);

        controller.run();
    }
}