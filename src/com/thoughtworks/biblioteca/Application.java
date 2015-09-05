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
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        Menu menu = new Menu(options);
        menu.display();
        Scanner scanner = new Scanner(System.in);
        Input input = new Input(scanner);
        int option = input.getOption();
        while(option != -1) {
            if (option == 1) {
                ArrayList<Book> books = new ArrayList<Book>();
                books.add(new Book("Twilight", "Stephenie Meyer", 2005));
                books.add(new Book("Harry Potter", "J.K. Rowling", 2002));
                BookList bookList = new BookList(books);
                Display displayBookList = new Display(bookList.toString());
                displayBookList.display();
            } else {
                Display displayBookList = new Display("Select a valid option!");
                displayBookList.display();
            }
            option = input.getOption();
        }
    }
}
