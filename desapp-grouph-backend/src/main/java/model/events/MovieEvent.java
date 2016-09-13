package model.events;

import model.users.MovieGenre;
import model.users.Profile;

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

    @Override
    public boolean possiblyLikes(Profile profile) {
        return (genres.stream()
                .anyMatch(movieGenre -> profile.likeMovieGenre(movieGenre)))
                ||
                profile.likeManyMovieGenres();
    }
}
