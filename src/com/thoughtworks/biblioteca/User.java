package com.thoughtworks.biblioteca;

public class User {

    private String libraryNumber;
    private String password;
    public enum type {CUSTOMER, LIBRARIAN, INVALID};
    private type userType;

    public User(String libraryNumber, String password, type userType) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.userType = userType;
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

    public boolean authenticate(User thatUser) {
        return password.equals(thatUser.password) && this.equals(thatUser);
    }
}