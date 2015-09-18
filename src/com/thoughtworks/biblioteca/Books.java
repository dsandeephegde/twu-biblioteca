//Contains List of books which can be checked out or returned
package com.thoughtworks.biblioteca;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Books {

    private ArrayList<Book> availableBooks;
    private HashMap<Book, User> checkOutBooksHash = new HashMap<>();

    public Books(ArrayList<Book> availableBooks) {
        this.availableBooks = availableBooks;
    }

    public String bookList() {
        String listBookString = "";
        listBookString += String.format("%-40s%-40s%-40s", "Book Name", "Author", "Year Published") + "\n";
        for (Book book : availableBooks) {
            listBookString += book.toString() + "\n";
        }
        return listBookString;
    }

    public Boolean checkoutBook(Book book, User user) {
        for (Book aBook : availableBooks) {
            if (aBook.equals(book)) {
                checkOutBooksHash.put(aBook, user);
                availableBooks.remove(aBook);
                return true;
            }
        }
        return false;
    }

    public Boolean returnBook(Book book, User user) {
        User searchedUser = checkOutBooksHash.get(book);
        for (Book aBook : checkOutBooksHash.keySet())
            if (aBook.equals(book) && user == searchedUser) {
                availableBooks.add(aBook);
                checkOutBooksHash.remove(aBook);
                return true;
            }
        return false;
    }

    public String checkedOutBookDetails() {
        String checkedOutBookDetails = "";
        Set set = checkOutBooksHash.entrySet();
        for (Object aSet : set) {
            Map.Entry entry = (Map.Entry) aSet;
            checkedOutBookDetails += "\nBook: \n" + entry.getKey().toString() + "\nCustomer: \n" + ((User)entry.getValue()).userDetails() + "\n";
        }
        return checkedOutBookDetails;
    }
}
