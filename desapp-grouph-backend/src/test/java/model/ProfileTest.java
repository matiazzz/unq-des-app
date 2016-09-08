package model;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class ProfileTest{


    public Profile newProfileWith(FoodType type){
        return ProfileBuilder.anyProfile().with(type).build();
    }
    public Profile newProfileWith(MusicalGenre genre){
        return ProfileBuilder.anyProfile().with(genre).build();
    }
    public Profile newProfileWith(MovieGenre genre){
        return ProfileBuilder.anyProfile().with(genre).build();
    }


    @Test
    public void likeMusicalGenreShouldReturnTrue(){
        Profile profile = newProfileWith(MusicalGenre.JAZZ);
        Assert.assertTrue(profile.likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void likeFoodTypeShouldReturnTrue(){
        Profile profile = newProfileWith(FoodType.CHINESE);
        Assert.assertTrue(profile.likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void likeMovieGenreShouldReturnTrue(){
        Profile profile = newProfileWith(MovieGenre.ACTION);
        Assert.assertTrue(profile.likeMovieGenre(MovieGenre.ACTION));
    }

    @Test
    public void shouldAddMusicalGenre(){
        Profile profile = newProfileWith(MusicalGenre.JAZZ);
        Assert.assertTrue(profile.likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void shouldRemoveAMusicalGenre(){
        Profile profile = newProfileWith(MusicalGenre.JAZZ);
        profile.removeMusicalGenre(MusicalGenre.JAZZ);
        Assert.assertFalse(profile.likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void shouldAddaFoodType(){
        Profile profile = newProfileWith(FoodType.CHINESE);
        Assert.assertTrue(profile.likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void shouldRemoveAFoodType(){
        Profile profile = newProfileWith(FoodType.CHINESE);
        profile.removeFoodType(FoodType.CHINESE);
        Assert.assertFalse(profile.likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void shouldAddMovieGenre(){
        Profile profile = newProfileWith(MovieGenre.ACTION);
        Assert.assertTrue(profile.likeMovieGenre(MovieGenre.ACTION));
    }

    @Test
    public void shouldRemoveAMovieGenre(){
        Profile profile = newProfileWith(MovieGenre.ACTION);
        profile.removeMovieGenre(MovieGenre.ACTION);
        Assert.assertFalse(profile.likeMovieGenre(MovieGenre.ACTION));
    }

}
