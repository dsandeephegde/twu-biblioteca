package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Menu {

    private ArrayList<String> menuList = new ArrayList<String>();
    private Library library;
    private Input input;

    Menu(ArrayList<String> menuList, Library library, Input input) {
        this.menuList = menuList;
        this.library = library;
        this.input = input;
    }

    public void display() {
        String menuString = "";
        for (String menuItem : menuList)
            menuString += menuItem + "\n";
        Display display = new Display(menuString);
        display.display();
    }

    public MenuItem selectMenuItem(String inputString) {
        int option = 0;
        try {
            option = Integer.parseInt(inputString);
        } catch (Exception ignored) {
        }
        switch (option) {
            case 1:
                return new ListBooks(library);
            case 2:
                return new Quit();
            case 3:
                return new CheckOutBook(library, input);
        }
        return new InvalidMenuItem();
    }
}