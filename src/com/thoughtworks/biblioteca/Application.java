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

        ArrayList<String> menuItems = new ArrayList<String>();
        menuItems.add("1. List Books");
        menuItems.add("2. Exit");
        menuItems.add("3. CheckOut");
        Menu menu = new Menu(menuItems, library);

        menu.display();

        Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);
        int option = input.getOption();
        while(true) {
            menu.selectOption(option);
            option = input.getOption();
        }
    }
}