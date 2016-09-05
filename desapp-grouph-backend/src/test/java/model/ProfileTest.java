package model;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ProfileTest{

    @Test
    public void likeMusicalGenreShouldReturnTrue(){
        Profile profile = new Profile();

        profile.addMusicalGenre(MusicalGenre.JAZZ);

        boolean ret = profile.likeMusicalGenre(MusicalGenre.JAZZ);

        Assert.assertTrue(ret);
    }

    @Test
    public void likeFoodTypeShouldReturnTrue(){
        Profile profile = new Profile();
        profile.addFoodType(FoodType.CHINESE);
        boolean ret = profile.likeFoodType(FoodType.CHINESE);
        Assert.assertTrue(ret);
    }

    @Test
    public void likeMovieGenreShouldReturnTrue(){
        Profile profile = new Profile();
        profile.addMovieGenre(MovieGenre.ACTION);
        boolean ret = profile.likeMovieGenre(MovieGenre.ACTION);
        Assert.assertTrue(ret);
    }

    @Test
    public void shouldAddMusicalGenre(){
        Profile profile = new Profile();

        profile.addMusicalGenre(MusicalGenre.JAZZ);

        Assert.assertTrue(profile.likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void shouldRemoveAMusicalGenre(){
        Profile profile = new Profile();

        profile.addMusicalGenre(MusicalGenre.JAZZ);

        profile.removeMusicalGenre(MusicalGenre.JAZZ);

        Assert.assertFalse(profile.likeMusicalGenre(MusicalGenre.JAZZ));
    }


    @Test
    public void shouldAddaFoodType(){
        Profile profile = new Profile();

        profile.addFoodType(FoodType.CHINESE);

        Assert.assertTrue(profile.likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void shouldRemoveAFoodType(){
        Profile profile = new Profile();

        profile.addFoodType(FoodType.CHINESE);

        profile.removeFoodType(FoodType.CHINESE);

        Assert.assertFalse(profile.likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void shouldAddMovieGenre(){
        Profile profile = new Profile();

        profile.addMovieGenre(MovieGenre.ACTION);

        Assert.assertTrue(profile.likeMovieGenre(MovieGenre.ACTION));
    }

    @Test
    public void shouldRemoveAMovieGenre(){
        Profile profile = new Profile();

        profile.addMovieGenre(MovieGenre.ACTION);

        profile.removeMovieGenre(MovieGenre.ACTION);

        Assert.assertFalse(profile.likeMovieGenre(MovieGenre.ACTION));
    }

}
