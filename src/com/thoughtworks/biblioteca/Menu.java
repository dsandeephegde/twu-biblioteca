package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Menu {

    ArrayList<String> menuList = new ArrayList<String>();

    Menu(ArrayList<String> menuList) {
        this.menuList = menuList;
    }

    public void display() {
        String menuString = "";
        for(String menuItem : menuList)
            menuString += menuItem + "\n";
        Display display = new Display(menuString);
        display.display();
    }
}