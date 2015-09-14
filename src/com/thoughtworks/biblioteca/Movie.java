//Stores the Movie name, director and rating
package com.thoughtworks.biblioteca;

public class Movie {

    private String name;
    private String director;
    private String rating;

    public Movie(String name, String director, String rating) {
        this.name = name;
        this.director = director;
        this.rating = rating;
    }

    @Override
    public String toString() {
        return String.format("%-40s%-40s%-40s", name, director, rating);
    }
}
