package com.thoughtworks.biblioteca;

import java.util.Scanner;

public class Input {

    Scanner scanner;

    Input(Scanner scanner) {
        this.scanner = scanner;
    }

    public int getOption() {
        return Integer.parseInt(scanner.nextLine());
    }
}