package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Menu {

    private ArrayList<String> menuList = new ArrayList<String>();
    private Library library;
    private Input input;

    public Menu(ArrayList<String> menuList, Library library, Input input) {
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

    public MenuItem selectMenuItem(String option) {
        if (option.equals("1")) {
            return new ListBooks(library);
        } else if (option.equals("2")) {
            return new Quit();
        } else if (option.equals("3")) {
            return new CheckOutBook(library, input);
        } else if (option.equals("4")) {
            return new ReturnBook(library, input);
        }
        return new InvalidMenuItem();
    }
}