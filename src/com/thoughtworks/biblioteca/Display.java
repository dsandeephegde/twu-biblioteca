//Used to display to the output
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Display {

    ArrayList<String> books;

    Display(ArrayList<String> books) {
        this.books = books;
    }

    public void display(String message) {
        System.out.println(message);
    }

    public void displayBooks() {
        for (String book : books) {
            display(book);
        }
    }
}