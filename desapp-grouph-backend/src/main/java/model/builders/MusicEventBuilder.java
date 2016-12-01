package model.builders;

import model.events.MusicEvent;
import model.users.MusicalGenre;

import java.util.ArrayList;
import java.util.List;


public class MusicEventBuilder {

    private List<MusicalGenre> musicalGenres;

    public MusicEventBuilder() {
        this.musicalGenres = new ArrayList<>();
    }

    public static MusicEventBuilder anyMusicEvent() {
        return new MusicEventBuilder();
    }

    public MusicEvent build() {
        MusicEvent musicEvent = new MusicEvent();
        musicEvent.setGenres(this.musicalGenres);
        return musicEvent;
    }
}
