//It is Menu Item which represents the invalid option
package com.thoughtworks.biblioteca;

public class InvalidMenuItem implements MenuItem {

    private View view;

    public InvalidMenuItem(View view) {
        this.view = view;
    }

    @Override
    public void performOperation() {
        view.output("Select a valid option!\n");
    }
}
