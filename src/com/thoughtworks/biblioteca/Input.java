package com.thoughtworks.biblioteca;

import java.util.Scanner;

public class Input {

    Scanner scanner;

    Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getOption() {
        try {
            return Integer.parseInt(scanner.nextLine());
        } catch (Exception e) {
            return -1;
        }
    }

    public String getString() {
        return scanner.nextLine();
    }
}