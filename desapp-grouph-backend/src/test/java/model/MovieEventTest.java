package model;

import model.events.MovieEvent;
import model.users.Profile;
import org.junit.Test;
import static model.users.MovieGenre.*;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieEventTest {

    @Test
    public void shouldCompareAnEventWithAProfile() {
        Profile mockedProfile = mock(Profile.class);
        MovieEvent movieEvent = new MovieEvent();

        movieEvent.addMovieGenre(ACTION);
        movieEvent.addMovieGenre(COMEDY);
        movieEvent.addMovieGenre(HORROR);

        when(mockedProfile.likeMovieGenre(ACTION)).thenReturn(false);
        when(mockedProfile.likeMovieGenre(COMEDY)).thenReturn(false);
        when(mockedProfile.likeMovieGenre(HORROR)).thenReturn(true);

        assertTrue(movieEvent.compareTo(mockedProfile));

        verify(mockedProfile).likeMovieGenre(ACTION);
        verify(mockedProfile).likeMovieGenre(COMEDY);
        verify(mockedProfile).likeMovieGenre(HORROR);
    }

    @Test
    public void shouldLikeTheMovieEvent(){
        MovieEvent event = new MovieEvent();
        event.addMovieGenre(ACTION);
        event.addMovieGenre(COMEDY);
        Profile profile = mock(Profile.class);
        when(profile.likeMovieGenre(COMEDY)).thenReturn(true);
        assertTrue(event.possiblyLikes(profile));
    }

    @Test
    public void shouldLikeTheMovieEventWhenLikeManyMovieEvents(){
        MovieEvent event = new MovieEvent();
        Profile profile = mock(Profile.class);
        when(profile.likeManyMovieGenres()).thenReturn(true);
        assertTrue(event.possiblyLikes(profile));
    }

}
