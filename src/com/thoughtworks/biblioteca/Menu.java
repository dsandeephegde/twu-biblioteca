package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    ArrayList<String> menuList = new ArrayList<String>();
    Library library;

    Menu(ArrayList<String> menuList, Library library) {
        this.menuList = menuList;
        this.library = library;
    }

    public void display() {
        String menuString = "";
        for (String menuItem : menuList)
            menuString += menuItem + "\n";
        Display display = new Display(menuString);
        display.display();
    }

    public void selectOption(int option) {
        if (option == 1) {
            library.displayBookList();
        } else if (option == 2) {
            System.exit(0);
        } else if(option == 3) {
            Input input = new Input(new Scanner(System.in));
            String book = input.getString();
            library.checkout(book);
        } else {
            Display display = new Display("Select a valid option!\n");
            display.display();
        }
    }
}