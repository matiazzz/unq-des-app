package model;

import model.events.MusicEvent;
import model.users.MusicalGenre;
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

        musicEvent.addMusicGenre(MusicalGenre.JAZZ);
        musicEvent.addMusicGenre(MusicalGenre.ROCK);
        musicEvent.addMusicGenre(MusicalGenre.REAGGE);

        when(mockedProfile.likeMusicalGenre(MusicalGenre.REAGGE)).thenReturn(true);
        when(mockedProfile.likeMusicalGenre(MusicalGenre.ROCK)).thenReturn(false);
        when(mockedProfile.likeMusicalGenre(MusicalGenre.JAZZ)).thenReturn(false);

        assertTrue(musicEvent.compareTo(mockedProfile));

        verify(mockedProfile).likeMusicalGenre(MusicalGenre.JAZZ);
        verify(mockedProfile).likeMusicalGenre(MusicalGenre.ROCK);
        verify(mockedProfile).likeMusicalGenre(MusicalGenre.REAGGE);
    }
}
