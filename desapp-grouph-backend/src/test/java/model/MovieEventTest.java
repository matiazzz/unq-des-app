package model;

import model.events.MovieEvent;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MovieEventTest {

    @Test
    public void shouldCompareAnEventWithAProfile() {
        Profile mockedProfile = mock(Profile.class);
        MovieEvent movieEvent = new MovieEvent();

        movieEvent.addMovieGenre(MovieGenre.ACTION);
        movieEvent.addMovieGenre(MovieGenre.COMEDY);
        movieEvent.addMovieGenre(MovieGenre.HORROR);

        when(mockedProfile.likeMovieGenre(MovieGenre.ACTION)).thenReturn(false);
        when(mockedProfile.likeMovieGenre(MovieGenre.COMEDY)).thenReturn(false);
        when(mockedProfile.likeMovieGenre(MovieGenre.HORROR)).thenReturn(true);

        assertTrue(movieEvent.compareTo(mockedProfile));

        verify(mockedProfile).likeMovieGenre(MovieGenre.ACTION);
        verify(mockedProfile).likeMovieGenre(MovieGenre.COMEDY);
        verify(mockedProfile).likeMovieGenre(MovieGenre.HORROR);
    }

}
