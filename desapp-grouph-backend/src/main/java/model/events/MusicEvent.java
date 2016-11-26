package model.events;

import model.users.MusicalGenre;
import model.users.Profile;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="MusicEvent")
@PrimaryKeyJoinColumn(name="id")
public class MusicEvent extends EventType {

    @ElementCollection(targetClass = MusicalGenre.class, fetch = FetchType.EAGER)
    @Enumerated(EnumType.STRING)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private Set<MusicalGenre> genres = new HashSet<>();

    public MusicEvent(Set<MusicalGenre> musicalGenres) {
        this.genres = musicalGenres;
    }

    public MusicEvent() {}

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
