//Input and Output of the Application is done here
package com.thoughtworks.biblioteca;

import java.io.PrintStream;
import java.util.Scanner;

public class View {

    private Scanner scanner;
    private PrintStream printStream;

    public View(Scanner scanner, PrintStream printStream) {
        this.scanner = scanner;
        this.printStream = printStream;
    }

    public String input() {
        return scanner.nextLine();
    }

    public void output(String message) {
        printStream.print(message);
    }
}
