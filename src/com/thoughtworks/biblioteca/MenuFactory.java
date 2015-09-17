package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;

public class MenuFactory {

    private Library library;
    private View view;
    private UserAccount userAccount;
    private Session session;

    public MenuFactory(Library library, View view, UserAccount userAccount, Session session) {
        this.library = library;
        this.view = view;
        this.userAccount = userAccount;
        this.session = session;
    }

    public Menu configureMenu(User currentUser) {
        User.type userType = currentUser.getUserType();
        if(userType == User.type.GUEST)
            return guestMenu();
        else if(userType == User.type.CUSTOMER)
            return customerMenu();
        else
            return librarianMenu();
    }

    private Menu guestMenu() {
        ArrayList<String> menuItems = new ArrayList<>();
        menuItems.add("1. List Books");
        menuItems.add("2. List Movie");
        menuItems.add("3. CheckOut Movie");
        menuItems.add("4. Login");
        menuItems.add("5. Exit");
        HashMap<String, MenuItem> menuItemsHashMap= new HashMap<>();
        menuItemsHashMap.put("1", new ListBooks(library, view));
        menuItemsHashMap.put("2", new ListMovies(library, view));
        menuItemsHashMap.put("3", new CheckOutMovie(library, view));
        menuItemsHashMap.put("4", new Login(view, userAccount, session));
        menuItemsHashMap.put("5", new Quit());
        menuItemsHashMap.put("invalid", new InvalidMenuItem(view));
        return new Menu(menuItems, menuItemsHashMap);
    }

    private Menu customerMenu() {
        ArrayList<String> menuItems = new ArrayList<>();
        menuItems.add("1. List Books");
        menuItems.add("2. CheckOut Book");
        menuItems.add("3. Return Book");
        menuItems.add("4. List Movie");
        menuItems.add("5. CheckOut Movie");
        menuItems.add("6. User Details");
        menuItems.add("7. Logout");
        menuItems.add("8. Exit");
        HashMap<String, MenuItem> menuItemsHashMap= new HashMap<>();
        menuItemsHashMap.put("1", new ListBooks(library, view));
        menuItemsHashMap.put("2", new CheckOutBook(library, view, session));
        menuItemsHashMap.put("3", new ReturnBook(library, view, session));
        menuItemsHashMap.put("4", new ListMovies(library, view));
        menuItemsHashMap.put("5", new CheckOutMovie(library, view));
        menuItemsHashMap.put("6", new UserDetails(session, view));
        menuItemsHashMap.put("7", new Logout(session));
        menuItemsHashMap.put("8", new Quit());
        menuItemsHashMap.put("invalid", new InvalidMenuItem(view));
        return new Menu(menuItems, menuItemsHashMap);
    }

    private Menu librarianMenu() {
        ArrayList<String> menuItems = new ArrayList<>();
        menuItems.add("1. List Books");
        menuItems.add("2. CheckOut Book");
        menuItems.add("3. Return Book");
        menuItems.add("4. List Movie");
        menuItems.add("5. CheckOut Movie");
        menuItems.add("6. User Details");
        menuItems.add("7. CheckedOut Book Details");
        menuItems.add("8. Logout");
        menuItems.add("9. Exit");
        HashMap<String, MenuItem> menuItemsHashMap= new HashMap<>();
        menuItemsHashMap.put("1", new ListBooks(library, view));
        menuItemsHashMap.put("2", new CheckOutBook(library, view, session));
        menuItemsHashMap.put("3", new ReturnBook(library, view, session));
        menuItemsHashMap.put("4", new ListMovies(library, view));
        menuItemsHashMap.put("5", new CheckOutMovie(library, view));
        menuItemsHashMap.put("6", new UserDetails(session, view));
        menuItemsHashMap.put("7", new CheckedOutBookDetails(library, view));
        menuItemsHashMap.put("8", new Logout(session));
        menuItemsHashMap.put("9", new Quit());
        menuItemsHashMap.put("invalid", new InvalidMenuItem(view));
        return new Menu(menuItems, menuItemsHashMap);
    }
}
