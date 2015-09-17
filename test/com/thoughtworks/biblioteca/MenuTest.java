package com.thoughtworks.biblioteca;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MenuTest {

    @Rule
    public final ExpectedSystemExit exit = ExpectedSystemExit.none();

    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Test
    public void shouldDisplayMenuList() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        HashMap<String, MenuItem> menuItemsHashMap= new HashMap<>();
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        Menu menu = new Menu(menus, menuItemsHashMap, view);

        menu.display();

        verify(view).output("1. List Books\n2. Quit\n");
    }

    @Test
    public void shouldCallDisplayBookListOnSelectingOptionOne() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("1. List Books");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        HashMap<String, MenuItem> menuItemsHashMap= new HashMap<>();
        menuItemsHashMap.put("1", new ListBooks(library));
        menuItemsHashMap.put("2", new CheckOutBook(library, view, session));
        menuItemsHashMap.put("3", new ReturnBook(library, view, session));
        menuItemsHashMap.put("4", new ListMovies(library));
        menuItemsHashMap.put("5", new CheckOutMovie(library, view));
        menuItemsHashMap.put("9", new Quit());
        menuItemsHashMap.put("invalid", new InvalidMenuItem(view));
        Menu menu = new Menu(menus, menuItemsHashMap, view);

        menu.selectMenuItem("1").performOperation();

        verify(library).displayBookList();
    }

    @Test
    public void shouldCallSystemExitOnSelectingOptionTwo() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        HashMap<String, MenuItem> menuItemsHashMap= new HashMap<>();
        menuItemsHashMap.put("1", new ListBooks(library));
        menuItemsHashMap.put("2", new CheckOutBook(library, view, session));
        menuItemsHashMap.put("3", new ReturnBook(library, view, session));
        menuItemsHashMap.put("4", new ListMovies(library));
        menuItemsHashMap.put("5", new CheckOutMovie(library, view));
        menuItemsHashMap.put("9", new Quit());
        menuItemsHashMap.put("invalid", new InvalidMenuItem(view));
        Menu menu = new Menu(menus, menuItemsHashMap, view);

        exit.expectSystemExitWithStatus(0);

        menu.selectMenuItem("9").performOperation();
    }

    @Test
    public void shouldDisplayInvalidOptionOnSelectingInvalidOption() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        HashMap<String, MenuItem> menuItemsHashMap= new HashMap<>();
        menuItemsHashMap.put("1", new ListBooks(library));
        menuItemsHashMap.put("2", new CheckOutBook(library, view, session));
        menuItemsHashMap.put("3", new ReturnBook(library, view, session));
        menuItemsHashMap.put("4", new ListMovies(library));
        menuItemsHashMap.put("5", new CheckOutMovie(library, view));
        menuItemsHashMap.put("9", new Quit());
        menuItemsHashMap.put("invalid", new InvalidMenuItem(view));
        Menu menu = new Menu(menus, menuItemsHashMap, view);

        menu.selectMenuItem("10").performOperation();

        verify(view).output("Select a valid option!\n");
    }

    @Test
    public void shouldCheckOutBookOnSelectingCheckOutOption() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(session.getCurrentUser()).thenReturn(user);
        HashMap<String, MenuItem> menuItemsHashMap= new HashMap<>();
        menuItemsHashMap.put("1", new ListBooks(library));
        menuItemsHashMap.put("2", new CheckOutBook(library, view, session));
        menuItemsHashMap.put("3", new ReturnBook(library, view, session));
        menuItemsHashMap.put("4", new ListMovies(library));
        menuItemsHashMap.put("5", new CheckOutMovie(library, view));
        menuItemsHashMap.put("9", new Quit());
        menuItemsHashMap.put("invalid", new InvalidMenuItem(view));
        Menu menu = new Menu(menus, menuItemsHashMap, view);

        menu.selectMenuItem("2").performOperation();

        verify(library).checkoutBook(view.input(), user);
    }

    @Test
    public void shouldReturnInvalidIfEnteredOptionIsInvalid() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        HashMap<String, MenuItem> menuItemsHashMap= new HashMap<>();
        menuItemsHashMap.put("1", new ListBooks(library));
        menuItemsHashMap.put("2", new CheckOutBook(library, view, session));
        menuItemsHashMap.put("3", new ReturnBook(library, view, session));
        menuItemsHashMap.put("4", new ListMovies(library));
        menuItemsHashMap.put("5", new CheckOutMovie(library, view));
        menuItemsHashMap.put("9", new Quit());
        menuItemsHashMap.put("invalid", new InvalidMenuItem(view));
        Menu menu = new Menu(menus, menuItemsHashMap, view);

        menu.selectMenuItem("invalid").performOperation();

        verify(view).output("Select a valid option!\n");
    }

    @Test
    public void shouldReturnBookOnSelectingReturnOption() {
        ArrayList<String> menus = new ArrayList<>();
        menus.add("1. List Books");
        menus.add("2. Quit");
        Library library = mock(Library.class);
        View view = mock(View.class);
        UserAccount userAccount = mock(UserAccount.class);
        Session session = mock(Session.class);
        User user = mock(User.class);
        when(session.getCurrentUser()).thenReturn(user);
        HashMap<String, MenuItem> menuItemsHashMap= new HashMap<>();
        menuItemsHashMap.put("1", new ListBooks(library));
        menuItemsHashMap.put("2", new CheckOutBook(library, view, session));
        menuItemsHashMap.put("3", new ReturnBook(library, view, session));
        menuItemsHashMap.put("4", new ListMovies(library));
        menuItemsHashMap.put("5", new CheckOutMovie(library, view));
        menuItemsHashMap.put("9", new Quit());
        menuItemsHashMap.put("invalid", new InvalidMenuItem(view));
        Menu menu = new Menu(menus, menuItemsHashMap, view);

        menu.selectMenuItem("3").performOperation();

        verify(library).returnBook(view.input(), user);
    }
}