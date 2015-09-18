//Contains List of Movies which can be checked out
package com.thoughtworks.biblioteca;

import java.util.ArrayList;

public class Movies {

    private ArrayList<Movie> movies;

    public Movies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public String movieList() {
        String listMovieString = "";
        listMovieString += String.format("%-40s%-40s%-40s%-40s", "Movie Name", "Year", "Director", "Rating") + "\n";
        for (Movie movie : movies) {
            listMovieString += movie.toString() + "\n";
        }
        return listMovieString;
    }

    public Boolean checkOutMovie(Movie movie) {
        for (Movie aMovie : movies) {
            if (aMovie.equals(movie)) {
                movies.remove(aMovie);
                return true;
            }
        }
        return false;
    }
}