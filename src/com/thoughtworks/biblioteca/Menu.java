//Menu is the Main menu of application which has menu options and menu item
package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private ArrayList<String> menuList;
    private HashMap<String, MenuItem> menuItems;
    private View view;

    public Menu(ArrayList<String> menuList, HashMap<String, MenuItem> menuItems, View view) {
        this.menuList = menuList;
        this.menuItems = menuItems;
        this.view = view;
    }

    public void display() {
        String menuString = "";
        for (String menuItem : menuList)
            menuString += menuItem + "\n";
        view.output(menuString);
    }

    public MenuItem selectMenuItem(String option) {
        MenuItem menuItem = menuItems.get(option);
        if(menuItem == null)
            return menuItems.get("invalid");
        return menuItem;
    }
}