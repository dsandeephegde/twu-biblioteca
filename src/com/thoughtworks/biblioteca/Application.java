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
        View view = getView();
        displayWelcomeMessage(view);
        Library library = getLibrary();
        UserAccount userAccount = getUserAccount();
        Session session = getDefaultSession();
        MenuFactory menuFactory = new MenuFactory(library, view, userAccount, session);
        Controller controller = new Controller(view, menuFactory, session);
        controller.run();
    }

    private Session getDefaultSession() {
        return new Session(new User("111-0000", "abc", User.type.GUEST, "guser1", "guser1@gmail.com", "9999999999"));
    }

    private void displayWelcomeMessage(View view) {
        view.output("Welcome to Biblioteca\n");
    }

    private UserAccount getUserAccount() {
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("111-1111", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999"));
        users.add(new User("111-2222", "xyz123", User.type.LIBRARIAN, "librarian1", "librarian1@gmail.com", "9999999999"));
        return new UserAccount(users);
    }

    private Library getLibrary() {
        ArrayList<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Twilight", "Stephenie Meyer", 2005));
        booksList.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        Books books = new Books(booksList);
        ArrayList<Movie> moviesList = new ArrayList<>();
        moviesList.add(new Movie("Bahubali", 2015, "S S Rajamouli", "9"));
        Movies movies = new Movies(moviesList);
        return new Library(books, movies);
    }

    private View getView() {
        PrintStream printStream = new PrintStream(System.out);
        Scanner scanner = new Scanner(System.in);
        return new View(scanner, printStream);
    }
}