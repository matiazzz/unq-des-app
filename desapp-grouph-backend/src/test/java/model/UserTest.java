package model;

import org.junit.Assert;
import org.junit.Test;
import static org.mockito.Mockito.*;

public class UserTest {

    @Test
    public void shouldAddAFriend(){
        User user1 = new User();
        User user2 = new User();
        user1.addFriend(user2);

        Assert.assertTrue(user1.getFriends().contains(user2));
    }

    @Test
    public void shouldConnectFriend(){
        User user1 = new User();
        User mockedUser = mock(User.class);
        user1.connectFriend(mockedUser);
        verify(mockedUser).addFriend(user1);
        Assert.assertTrue(user1.getFriends().contains(mockedUser));
    }

    @Test
    public void shouldCreateAddAndReturnAnEvent(){
        User user = new User();
        EventData eventData = new EventData("Test");

        Assert.assertTrue(user.createEvent(eventData).getTitle() == "Test");
    }

    @Test
    public void shouldAddAMusicGenreToTheProfile(){
        User user = new User();

        user.addMusicGenre(MusicalGenre.JAZZ);

        Assert.assertTrue(user.getProfile().likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void shouldRemoveAMusicalGenreFromTheProfile(){
        User user = new User();
        user.addMusicGenre(MusicalGenre.JAZZ);

        user.removeMusicalGenre(MusicalGenre.JAZZ);

        Assert.assertFalse(user.getProfile().likeMusicalGenre(MusicalGenre.JAZZ));
    }

    @Test
    public void shouldAddAMovieGenreToTheProfile(){
        User user = new User();

        user.addMovieGenre(MovieGenre.ACTION);

        Assert.assertTrue(user.getProfile().likeMovieGenre(MovieGenre.ACTION));
    }

    @Test
    public  void shouldRemoveAMovieGenreFromTheProfile(){
        User user = new User();
        user.addMovieGenre(MovieGenre.ACTION);

        user.removeMovieGenre(MovieGenre.ACTION);

        Assert.assertFalse(user.getProfile().likeMovieGenre(MovieGenre.ACTION));
    }

    @Test
    public void shouldAddAFoodTypeToTheProfile(){
        User user = new User();

        user.addFoodType(FoodType.CHINESE);

        Assert.assertTrue(user.getProfile().likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void shouldRemoveAFoodTypeFromTheProfile(){
        User user = new User();
        user.addFoodType(FoodType.CHINESE);

        user.removeFoodType(FoodType.CHINESE);

        Assert.assertFalse(user.getProfile().likeFoodType(FoodType.CHINESE));
    }

    @Test
    public void shouldSetAnAmountToTheProfile(){
        User user = new User();

        user.setAmount(500);

        Assert.assertTrue(user.getProfile().getMaxAmount() == 500);
    }

}
