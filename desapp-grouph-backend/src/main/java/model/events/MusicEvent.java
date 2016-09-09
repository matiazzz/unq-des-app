package model.events;

import model.MusicalGenre;
import model.Profile;
import java.util.ArrayList;
import java.util.List;

public class MusicEvent extends EventType {
    private List<MusicalGenre> genres = new ArrayList<MusicalGenre>();

    @Override
    public boolean compareTo(Profile profile) {
        return genres.stream().anyMatch(genre -> profile.likeMusicalGenre(genre));
    }

    public void addMusicGenre(MusicalGenre genre){
        genres.add(genre);
    }
}
