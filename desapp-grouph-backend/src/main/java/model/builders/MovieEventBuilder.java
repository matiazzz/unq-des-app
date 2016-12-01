package model.builders;

import model.events.MovieEvent;
import model.users.MovieGenre;

import java.util.ArrayList;
import java.util.List;


public class MovieEventBuilder {

    private List<MovieGenre> movieGenres;

    public MovieEventBuilder() {
        this.movieGenres = new ArrayList<>();
    }

    public static MovieEventBuilder anyMovieEvent() {
        return new MovieEventBuilder();
    }

    public MovieEvent build() {
        MovieEvent movieEvent = new MovieEvent();
        movieEvent.setGenres(this.movieGenres);
        return movieEvent;
    }
}
