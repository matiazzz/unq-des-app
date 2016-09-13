package model;

import model.events.MusicEvent;
import static model.users.MusicalGenre.*;
import model.users.Profile;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MusicEventTest {

    @Test
    public void shouldCompareAnEventWithAProfile(){
        Profile mockedProfile = mock(Profile.class);
        MusicEvent musicEvent = new MusicEvent();

        musicEvent.addMusicGenre(JAZZ);
        musicEvent.addMusicGenre(ROCK);
        musicEvent.addMusicGenre(REAGGE);

        when(mockedProfile.likeMusicalGenre(REAGGE)).thenReturn(true);
        when(mockedProfile.likeMusicalGenre(ROCK)).thenReturn(false);
        when(mockedProfile.likeMusicalGenre(JAZZ)).thenReturn(false);

        assertTrue(musicEvent.compareTo(mockedProfile));

        verify(mockedProfile).likeMusicalGenre(JAZZ);
        verify(mockedProfile).likeMusicalGenre(ROCK);
        verify(mockedProfile).likeMusicalGenre(REAGGE);
    }

    @Test
    public void shouldLikeTheMusicalEvent(){
        MusicEvent event = new MusicEvent();
        event.addMusicGenre(JAZZ);
        event.addMusicGenre(ROCK);
        Profile profile = mock(Profile.class);
        when(profile.likeMusicalGenre(JAZZ)).thenReturn(true);
        assertTrue(event.possiblyLikes(profile));
    }
}
