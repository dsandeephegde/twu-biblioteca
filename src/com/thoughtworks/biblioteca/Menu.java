package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private ArrayList<String> menuList = new ArrayList<String>();
    private HashMap<String, MenuItem> menuItems = new HashMap<String, MenuItem>();
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

    private void configureHash(){
        menuItems.put("1", new ListBooks(library));
        menuItems.put("2", new Quit());
        menuItems.put("3", new CheckOutBook(library, input));
        menuItems.put("4", new ReturnBook(library, input));
        menuItems.put("invalid", new InvalidMenuItem());
    }

    public MenuItem selectMenuItem(String option) {
        configureHash();
        MenuItem menuItem = menuItems.get(option);
        if(menuItem == null)
            return menuItems.get("invalid");
        return menuItem;
    }
}