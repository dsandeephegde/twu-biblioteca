package com.thoughtworks.biblioteca;

public class Controller {
    private View view;
    private Menu menu;

    public Controller(View view, Menu menu) {
        this.view = view;
        this.menu = menu;
    }

    public void run() {
        menu.display();
        while(true) {
            MenuItem menuItem = menu.selectMenuItem(view.input());
            menuItem.performOperation();
            menu.display();
        }
    }
}
