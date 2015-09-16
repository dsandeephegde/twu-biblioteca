//user is the specific person who has library number to access the library books
package com.thoughtworks.biblioteca;

public class User {

    private String libraryNumber;
    private String password;
    public enum type {CUSTOMER, LIBRARIAN, GUEST}
    private type userType;
    private String name;
    private String emailAddress;
    private String phoneNumber;

    public type getUserType() {
        return userType;
    }

    public User(String libraryNumber, String password, type userType, String name, String emailAddress, String phoneNumber) {
        this.libraryNumber = libraryNumber;
        this.password = password;
        this.userType = userType;
        this.name = name;
        this.emailAddress = emailAddress;
        this.phoneNumber = phoneNumber;
    }

    public void displayDetails(View view) {
        String userString = "";
        userString += String.format("%-40s%-40s%-40s%-40s\n%-40s%-40s%-40s%-40s\n", "library Number", "Name", "Email Address", "Phone Number", libraryNumber, name, emailAddress, phoneNumber);
        view.output(userString);
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