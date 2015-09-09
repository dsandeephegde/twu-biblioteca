package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class QuitTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    @Test
    public void shouldQuitApplicationOnPerformOperation() {
        Quit quit = new Quit();
        exit.expectSystemExitWithStatus(0);
        quit.performOperation();
    }
}