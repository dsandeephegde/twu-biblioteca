package com.thoughtworks.biblioteca;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class BooksTest {

    @Test
    public void shouldReturnStringInACorrectFormatDisplayBookList() {
        ArrayList<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Twilight", "Stephenie Meyer", 2005));
        booksList.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        Books books = new Books(booksList);

        assertEquals(String.format("%-40s%-40s%-40s\n%-40s%-40s%-40d\n%-40s%-40s%-40d\n", "Book Name", "Author", "Year Published", "Twilight", "Stephenie Meyer", 2005, "Harry Potter", "J.K. Rowling", 2002), books.bookList());
    }

    @Test
    public void shouldCheckOutBookFromLibraryIfAvailable() {
        ArrayList<Book> booksList = new ArrayList<>();
        Book book = new Book("Twilight", "Stephenie Meyer", 2005);
        booksList.add(book);
        booksList.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        User user = mock(User.class);
        Books books = new Books(booksList);
        assertEquals(true, books.checkoutBook(book, user));
    }

    @Test
    public void shouldNotCheckOutBookFromLibraryIfNotPresent() {
        ArrayList<Book> booksList = new ArrayList<>();
        booksList.add(new Book("Twilight", "Stephenie Meyer", 2005));
        booksList.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        Book book = new Book("Harry Potter 3", null, 0);
        User user = mock(User.class);
        Books books = new Books(booksList);
        assertEquals(false, books.checkoutBook(book, user));
    }

    @Test
    public void shouldNotCheckOutBookIfAlreadyCheckedOut() {
        ArrayList<Book> booksList = new ArrayList<>();
        Book book = new Book("Twilight", "Stephenie Meyer", 2005);
        booksList.add(book);
        booksList.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        User user = mock(User.class);
        Books books = new Books(booksList);
        books.checkoutBook(book, user);
        assertEquals(false, books.checkoutBook(book, user));
    }

    @Test
    public void shouldReturnBookToLibrary() {
        ArrayList<Book> booksList = new ArrayList<>();
        Book book = new Book("Twilight", "Stephenie Meyer", 2005);
        booksList.add(book);
        booksList.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        User user = mock(User.class);
        Books books = new Books(booksList);
        books.checkoutBook(book, user);
        assertEquals(true, books.returnBook(book, user));
    }

    @Test
    public void shouldNotReturnBookToLibraryIfNotALibraryBook() {
        ArrayList<Book> booksList = new ArrayList<>();
        Book book = new Book("Twilight", "Stephenie Meyer", 2005);
        booksList.add(book);
        booksList.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        User user = mock(User.class);
        Books books = new Books(booksList);
        Book book1 = new Book("Harry Potter 3", null, 0);
        books.checkoutBook(book, user);
        assertEquals(false, books.returnBook(book1, user));
    }

    @Test
    public void shouldNotReturnBookToLibraryIfAlreadyAvailable() {
        ArrayList<Book> booksList = new ArrayList<>();
        Book book = new Book("Twilight", "Stephenie Meyer", 2005);
        booksList.add(book);
        booksList.add(new Book("Harry Potter", "J.K. Rowling", 2002));
        Books books = new Books(booksList);
        User user = mock(User.class);
        assertEquals(false, books.returnBook(book, user));
    }

    @Test
    public void shouldNotReturnBookToLibraryForADifferentUser() {
        ArrayList<Book> booksList = new ArrayList<>();
        Book book1 = new Book("Twilight", "Stephenie Meyer", 2005);
        booksList.add(book1);
        Book book2 = new Book("Harry Potter", "J.K. Rowling", 2002);
        booksList.add(book2);
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        Books books = new Books(booksList);
        books.checkoutBook(book1, user2);
        books.checkoutBook(book2, user1);
        assertEquals(false, books.returnBook(book2, user2));
    }

    @Test
    public void shouldReturnBookForSameUser() {
        ArrayList<Book> booksList = new ArrayList<>();
        Book book1 = new Book("Twilight", "Stephenie Meyer", 2005);
        booksList.add(book1);
        Book book2 = new Book("Harry Potter", "J.K. Rowling", 2002);
        booksList.add(book2);
        Books books = new Books(booksList);
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        books.checkoutBook(book2, user1);
        books.checkoutBook(book1, user2);
        assertEquals(true, books.returnBook(book2, user1));
    }

    @Test
    public void shouldReturnCheckedOutBookDetails() {
        ArrayList<Book> booksList = new ArrayList<>();
        Book book1 = new Book("Twilight", "Stephenie Meyer", 2005);
        booksList.add(book1);
        Book book2 = new Book("Harry Potter", "J.K. Rowling", 2002);
        booksList.add(book2);
        Books books = new Books(booksList);
        User user = new User("111-2222", "abc123", User.type.CUSTOMER, "user1", "user1@gmail.com", "9999999999");
        books.checkoutBook(book1, user);
        assertEquals(String.format("\nBook: \n%-40s%-40s%-40d\nCustomer: \n%-40s%-40s\n%-40s%-40s\n%-40s%-40s\n%-40s%-40s\n\n", "Twilight", "Stephenie Meyer", 2005, "library Number", "111-2222", "Name", "user1", "Email Address", "user1@gmail.com", "Phone Number", "9999999999"), books.checkedOutBookDetails());
    }
}