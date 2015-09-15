package com.thoughtworks.biblioteca;

public class User {

    private String libraryNumber;
    private String password;

    public User(String libraryNumber, String password) {
        this.libraryNumber = libraryNumber;
        this.password = password;
    }

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null || getClass() != that.getClass()) return false;
        User user = (User) that;
        return libraryNumber.equals(user.libraryNumber);
    }

    @Override
    public int hashCode() {
        return libraryNumber.hashCode();
    }
}