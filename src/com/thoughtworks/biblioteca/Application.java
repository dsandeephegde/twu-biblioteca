package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Application application = new Application();
        application.start();
    }

    public void start() {
        String welcome = "Welcome to Biblioteca\n";
        Display displayWelcome = new Display(welcome);
        displayWelcome.display();

        ArrayList<Book> books = new ArrayList<Book>();
        books.add(new Book("Twilight", "Stephenie Meyer", 2005));
        books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        Library library = new Library(books);

        Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);

        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("1. List Books");
        menuItems.add("2. Exit");
        menuItems.add("3. CheckOut");
        menuItems.add("4. Return");
        Menu menu = new Menu(menuItems, library, input);

        menu.display();

        while(true) {
            MenuItem menuItem = menu.selectMenuItem(input.getInput());
            menuItem.performOperation();
            menu.display();
        }
    }
}