package model;

import org.junit.Assert;
import org.junit.Test;
import static model.builders.ProfileBuilder.anyProfile;

public class ProfileTest {

    @Test
    public void likeMusicalGenreShouldReturnTrue(){
        Profile profile = anyProfile().with(MusicalGenre.JAZZ).build();
        Assert.assertTrue(profile.likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void likeMusicalGenreShouldReturnFalse(){
        Profile profile = anyProfile().build();
        Assert.assertFalse(profile.likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void likeFoodTypeShouldReturnTrue(){
        Profile profile = anyProfile().with(FoodType.CHINESE).build();
        Assert.assertTrue(profile.likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void likeMovieGenreShouldReturnTrue(){
        Profile profile = anyProfile().with(MovieGenre.ACTION).build();
        Assert.assertTrue(profile.likeMovieGenre(MovieGenre.ACTION));
    }

    @Test
    public void shouldAddMusicalGenre(){
        Profile profile = anyProfile().with(MusicalGenre.JAZZ).build();
        Assert.assertTrue(profile.likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void shouldRemoveAMusicalGenre(){
        Profile profile = anyProfile().with(MusicalGenre.JAZZ).build();
        profile.removeMusicalGenre(MusicalGenre.JAZZ);
        Assert.assertFalse(profile.likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void shouldAddaFoodType(){
        Profile profile = anyProfile().with(FoodType.CHINESE).build();
        Assert.assertTrue(profile.likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void shouldRemoveAFoodType(){
        Profile profile = anyProfile().with(FoodType.CHINESE).build();
        profile.removeFoodType(FoodType.CHINESE);
        Assert.assertFalse(profile.likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void shouldAddMovieGenre(){
        Profile profile = anyProfile().with(MovieGenre.ACTION).build();
        Assert.assertTrue(profile.likeMovieGenre(MovieGenre.ACTION));
    }

    @Test
    public void shouldRemoveAMovieGenre(){
        Profile profile = anyProfile().with(MovieGenre.ACTION).build();
        profile.removeMovieGenre(MovieGenre.ACTION);
        Assert.assertFalse(profile.likeMovieGenre(MovieGenre.ACTION));
    }
}
