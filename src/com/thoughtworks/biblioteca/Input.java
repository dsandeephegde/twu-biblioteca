package com.thoughtworks.biblioteca;

import java.util.Scanner;

public class Input {

    Scanner scanner;

    public Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public String getInput() {
        return scanner.nextLine();
    }
}