//Controls the Flow of the Whole Application
package com.thoughtworks.biblioteca;

public class Controller {
    private View view;
    private Menu menu;
    private Session session;

    public Controller(View view, Menu menu, Session session) {
        this.view = view;
        this.menu = menu;
        this.session = session;
    }

    public void run() {
        while(true) {
            menu.display();
            MenuItem menuItem = menu.selectMenuItem(view.input());
            menuItem.performOperation();
        }
    }
}
