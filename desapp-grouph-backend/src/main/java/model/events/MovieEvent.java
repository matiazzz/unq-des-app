package model.events;

import model.users.MovieGenre;
import model.users.Profile;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MovieEvent")
@PrimaryKeyJoinColumn(name="id")
public class MovieEvent extends EventType {

    @ElementCollection(targetClass = MovieGenre.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private List<MovieGenre> genres = new ArrayList<>();

    public MovieEvent(List<MovieGenre> movieGenres) {
        this.genres = movieGenres;
    }

    public MovieEvent() {}

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
