package model.events;

import model.MovieGenre;
import model.Profile;

import java.util.ArrayList;
import java.util.List;

public class MovieEvent extends EventType{

    private List<MovieGenre> genres = new ArrayList<MovieGenre>();

    @Override
    public boolean compareTo(Profile profile) {
        return genres.stream().anyMatch(genre -> profile.likeMovieGenre(genre));
    }

    public void addMovieGenre(MovieGenre genre){
        genres.add(genre);
    }
}
