//Menu is the Main menu of application which has menu options and menu item
package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private ArrayList<String> menuList;
    private HashMap<String, MenuItem> menuItems = new HashMap<String, MenuItem>();
    private Library library;
    private View view;

    public Menu(ArrayList<String> menuList, Library library, View view) {
        this.menuList = menuList;
        this.library = library;
        this.view = view;
        configureHash();
    }

    public void display() {
        String menuString = "";
        for (String menuItem : menuList)
            menuString += menuItem + "\n";
        view.output(menuString);
    }

    private void configureHash(){
        menuItems.put("1", new ListBooks(library));
        menuItems.put("2", new Quit());
        menuItems.put("3", new CheckOutBook(library, view));
        menuItems.put("4", new ReturnBook(library, view));
        menuItems.put("invalid", new InvalidMenuItem(view));
    }

    public MenuItem selectMenuItem(String option) {
        MenuItem menuItem = menuItems.get(option);
        if(menuItem == null)
            return menuItems.get("invalid");
        return menuItem;
    }
}