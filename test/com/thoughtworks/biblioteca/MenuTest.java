package com.thoughtworks.biblioteca;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class MenuTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void shouldDisplayMenuList() {
        ArrayList<String> options = new ArrayList<String>();
        options.add("1. List Books");
        Library library = mock(Library.class);
        Menu menu = new Menu(options, library);
        System.setOut(new PrintStream(outContent));
        menu.display();
        assertEquals("1. List Books\n", outContent.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldCallDisplayBookListOnSelectingOptionOne() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        Library library = mock(Library.class);
        Menu menu = new Menu(menus, library);
        menu.selectOption(1);
        verify(library).displayBookList();
    }

    @Test
    public void shouldCallSystemExitOnSelectingOptionTwo() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        Menu menu = new Menu(menus, library);
        exit.expectSystemExitWithStatus(0);
        menu.selectOption(2);
    }

    @Test
    public void shouldDisplayInvalidOptionOnSelectingInvalidOption() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Library library = mock(Library.class);
        Menu menu = new Menu(menus, library);
        menu.selectOption(3);
        assertEquals("Select a valid option!\n", outContent.toString());
        System.setOut(System.out);
    }
}