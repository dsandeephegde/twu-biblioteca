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

    @Override
    public boolean equals(Object that) {
        if (this == that) return true;
        if (that == null) return false;
        if(getClass() != that.getClass()) return false;
        Movie movie = (Movie) that;
        return name.equals(movie.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }
}
