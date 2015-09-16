package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
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
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Menu menu = new Menu(options, library, view, userAccount, session);

        menu.display();

        verify(view).output("1. List Books\n2. Quit\n");
    }

    @Test
    public void shouldCallDisplayBookListOnSelectingOptionOne() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Menu menu = new Menu(menus, library, view, userAccount, session);

        menu.selectMenuItem("1").performOperation();

        verify(library).displayBookList();
    }

    @Test
    public void shouldCallSystemExitOnSelectingOptionTwo() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Menu menu = new Menu(menus, library, view, userAccount, session);

        exit.expectSystemExitWithStatus(0);

        menu.selectMenuItem("2").performOperation();
    }

    @Test
    public void shouldDisplayInvalidOptionOnSelectingInvalidOption() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Menu menu = new Menu(menus, library, view, userAccount, session);

        menu.selectMenuItem("10").performOperation();

        verify(view).output("Select a valid option!\n");
    }

    @Test
    public void shouldCheckOutBookOnSelectingCheckOutOption() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Menu menu = new Menu(menus, library, view, userAccount, session);

        menu.selectMenuItem("3").performOperation();

        verify(library).checkoutBook(view.input());
    }

    @Test
    public void shouldReturnInvalidIfEnteredOptionIsInvalid() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Menu menu = new Menu(menus, library, view, userAccount, session);

        menu.selectMenuItem("invalid").performOperation();

        verify(view).output("Select a valid option!\n");
    }

    @Test
    public void shouldReturnBookOnSelectingReturnOption() {
        ArrayList<String> menus = new ArrayList<String>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Menu menu = new Menu(menus, library, view, userAccount, session);

        menu.selectMenuItem("4").performOperation();

        verify(library).returnBook(view.input());
    }
}