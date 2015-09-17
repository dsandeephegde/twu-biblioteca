//Stores the Session information of the Application. ie. currently logged in user
package com.thoughtworks.biblioteca;

public class Session {

    private User user;

    public Session(User user) {
        this.user = user;
    }

    public User getCurrentUser() {
        return user;
    }

    public void setCurrentUser(User currentUser) {
        this.user = currentUser;
    }
}
