//Controls the Flow of the Whole Application
package com.thoughtworks.biblioteca;

public class Controller {
    private View view;
    private MenuFactory menuFactory;
    private Session session;

    public Controller(View view, MenuFactory menuFactory, Session session) {
        this.view = view;
        this.menuFactory = menuFactory;
        this.session = session;
    }

    public void run() {
        Menu menu;
        while(true) {
            menu = menuFactory.configureMenu(session.getCurrentUser());
            menu.display();
            MenuItem menuItem = menu.selectMenuItem(view.input());
            menuItem.performOperation();
        }
    }
}