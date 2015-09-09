package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
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
        options.add("2. Quit");
        Library library = mock(Library.class);
        Input input = mock(Input.class);
        Menu menu = new Menu(options, library, input);
        System.setOut(new PrintStream(outContent));
        menu.display();
        assertEquals("1. List Books\n2. Quit\n", outContent.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldCallDisplayBookListOnSelectingOptionOne() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        Library library = mock(Library.class);
        Input input = mock(Input.class);
        Menu menu = new Menu(menus, library, input);
        menu.selectMenuItem("1").performOperation();
        verify(library).displayBookList();
    }

    @Test
    public void shouldCallSystemExitOnSelectingOptionTwo() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        Input input = mock(Input.class);
        Menu menu = new Menu(menus, library, input);
        exit.expectSystemExitWithStatus(0);
        menu.selectMenuItem("2").performOperation();
    }

    @Test
    public void shouldDisplayInvalidOptionOnSelectingInvalidOption() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Library library = mock(Library.class);
        Input input = mock(Input.class);
        Menu menu = new Menu(menus, library, input);
        menu.selectMenuItem("10").performOperation();
        assertEquals("Select a valid option!\n", outContent.toString());
        System.setOut(System.out);
    }

    @Test
    public void shouldCheckOutBookOnSelectingCheckOutOption() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        Input input = mock(Input.class);
        Menu menu = new Menu(menus, library, input);
        menu.selectMenuItem("3").performOperation();
        verify(input).getInput();
        verify(library).checkout(input.getInput());
    }

    @Test
    public void shouldReturnInvalidIfEnteredOptionIsInvalid() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Library library = mock(Library.class);
        Input input = mock(Input.class);
        Menu menu = new Menu(menus, library, input);

        menu.selectMenuItem("invalid").performOperation();

        assertEquals("Select a valid option!\n", outContent.toString());
        System.setOut(System.out);
    }
}