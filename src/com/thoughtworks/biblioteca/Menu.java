//Menu is the Main menu of application which has menu options and menu item
package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class Menu {

    private ArrayList<String> menuList;
    private HashMap<String, MenuItem> menuItems;

    public Menu(ArrayList<String> menuList, HashMap<String, MenuItem> menuItems) {
        this.menuList = menuList;
        this.menuItems = menuItems;
    }

    public String menuList() {
        String menuString = "";
        for (String menuItem : menuList)
            menuString += menuItem + "\n";
        return menuString;
    }

    public MenuItem selectMenuItem(String option) {
        MenuItem menuItem = menuItems.get(option);
        if(menuItem == null)
            return menuItems.get("invalid");
        return menuItem;
    }
}