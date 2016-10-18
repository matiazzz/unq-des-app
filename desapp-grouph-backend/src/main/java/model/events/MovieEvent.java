package model.events;

import model.users.MovieGenre;
import model.users.Profile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MovieEvent")
public class MovieEvent extends EventType {

    @ElementCollection(targetClass = MovieGenre.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
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
