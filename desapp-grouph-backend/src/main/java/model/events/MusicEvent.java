package model.events;

import model.users.MusicalGenre;
import model.users.Profile;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="MusicEvent")
public class MusicEvent extends EventType {

    @ElementCollection(targetClass = MusicalGenre.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    private List<MusicalGenre> genres = new ArrayList<>();

    @Override
    public boolean compareTo(Profile profile) {
        return genres.stream().anyMatch(genre -> profile.likeMusicalGenre(genre));
    }

    public void addMusicGenre(MusicalGenre genre){
        genres.add(genre);
    }

    @Override
    public boolean possiblyLikes(Profile profile) {
        return (genres.stream()
                .anyMatch(musicalGenre -> profile.likeMusicalGenre(musicalGenre)))
                ||
                profile.likeManyMusicalGenres();
    }
}
