package model;

import org.junit.Assert;
import org.junit.Test;
import static model.FoodType.*;
import static model.MovieGenre.*;
import static model.MusicalGenre.*;
import static model.builders.ProfileBuilder.anyProfile;

public class ProfileTest {

    @Test
    public void likeMusicalGenreShouldReturnTrue(){
        Profile profile = anyProfile().with(JAZZ).build();
        Assert.assertTrue(profile.likeMusicalGenre(JAZZ));
    }

    @Test
    public void likeMusicalGenreShouldReturnFalse(){
        Profile profile = anyProfile().build();
        Assert.assertFalse(profile.likeMusicalGenre(JAZZ));
    }

    @Test
    public void likeFoodTypeShouldReturnTrue(){
        Profile profile = anyProfile().with(CHINESE).build();
        Assert.assertTrue(profile.likeFoodType(CHINESE));
    }

    @Test
    public void likeMovieGenreShouldReturnTrue(){
        Profile profile = anyProfile().with(ACTION).build();
        Assert.assertTrue(profile.likeMovieGenre(ACTION));
    }

    @Test
    public void shouldAddMusicalGenre(){
        Profile profile = anyProfile().with(JAZZ).build();
        Assert.assertTrue(profile.likeMusicalGenre(JAZZ));
    }

    @Test
    public void shouldRemoveAMusicalGenre(){
        Profile profile = anyProfile().with(JAZZ).build();
        profile.removeMusicalGenre(JAZZ);
        Assert.assertFalse(profile.likeMusicalGenre(JAZZ));
    }

    @Test
    public void shouldAddaFoodType(){
        Profile profile = anyProfile().with(CHINESE).build();
        Assert.assertTrue(profile.likeFoodType(CHINESE));
    }

    @Test
    public void shouldRemoveAFoodType(){
        Profile profile = anyProfile().with(CHINESE).build();
        profile.removeFoodType(CHINESE);
        Assert.assertFalse(profile.likeFoodType(CHINESE));
    }

    @Test
    public void shouldAddMovieGenre(){
        Profile profile = anyProfile().with(ACTION).build();
        Assert.assertTrue(profile.likeMovieGenre(ACTION));
    }

    @Test
    public void shouldRemoveAMovieGenre(){
        Profile profile = anyProfile().with(ACTION).build();
        profile.removeMovieGenre(ACTION);
        Assert.assertFalse(profile.likeMovieGenre(ACTION));
    }
}
