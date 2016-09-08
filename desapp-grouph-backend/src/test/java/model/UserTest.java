package model;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class UserTest {

    @Test
    public void shouldAddAFriend(){
        User userX = UserBuilder.anyUser().build();
        User userY = UserBuilder.anyUser().with(userX).build();

        Assert.assertTrue(userY.isFriendWith(userX));
    }

    @Test
    public void shouldConnectFriend(){
        User user1 = UserBuilder.anyUser().build();
        User mockedUser = mock(User.class);
        user1.connectFriend(mockedUser);
        verify(mockedUser).addFriend(user1);
        Assert.assertTrue(user1.isFriendWith(mockedUser));
    }

    @Test
    public void shouldCreateAddAndReturnAnEvent(){
        User user = UserBuilder.anyUser().build();
        EventData eventData = new EventData("Test");

        Assert.assertEquals(user.createEvent(eventData).getTitle(), "Test");
    }

    @Test
    public void shouldAddAMusicGenreToTheProfile(){
        User user = UserBuilder.anyUser().build();
        user.addMusicGenre(MusicalGenre.JAZZ);
        Assert.assertTrue(user.likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void shouldRemoveAMusicalGenreFromTheProfile(){
        User user = UserBuilder.anyUser().build();
        user.addMusicGenre(MusicalGenre.JAZZ);

        user.removeMusicalGenre(MusicalGenre.JAZZ);

        Assert.assertFalse(user.likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void shouldAddAMovieGenreToTheProfile(){
        User user = UserBuilder.anyUser().build();

        user.addMovieGenre(MovieGenre.ACTION);

        Assert.assertTrue(user.likeMovieGenre(MovieGenre.ACTION));
    }

    @Test
    public  void shouldRemoveAMovieGenreFromTheProfile(){
        User user = UserBuilder.anyUser().build();
        user.addMovieGenre(MovieGenre.ACTION);

        user.removeMovieGenre(MovieGenre.ACTION);

        Assert.assertFalse(user.likeMovieGenre(MovieGenre.ACTION));
    }

    @Test
    public void shouldAddAFoodTypeToTheProfile(){
        User user = UserBuilder.anyUser().build();

        user.addFoodType(FoodType.CHINESE);

        Assert.assertTrue(user.likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void shouldRemoveAFoodTypeFromTheProfile(){
        User user = UserBuilder.anyUser().build();
        user.addFoodType(FoodType.CHINESE);

        user.removeFoodType(FoodType.CHINESE);

        Assert.assertFalse(user.likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void shouldSetAnAmountToTheProfile(){
        User user = UserBuilder.anyUser().build();

        user.setAmount(500);

        Assert.assertEquals(user.getMaxAmount(), 500);
    }

}
