package model;

import model.events.EventData;
import model.plannings.Couple;
import model.plannings.Individual;
import model.plannings.WithFriends;
import org.junit.Assert;
import org.junit.Test;

import static model.FoodType.*;
import static model.MovieGenre.*;
import static model.MusicalGenre.*;
import static model.builders.UserBuilder.anyUser;
import static org.mockito.Mockito.*;

public class UserTest {

    @Test
    public void shouldAddAFriend(){
        User userX = anyUser().build();
        User userY = anyUser().with(userX).build();
        Assert.assertTrue(userY.isFriendOf(userX));
    }

    @Test
    public void shouldConnectFriend(){
        User user1 = anyUser().build();
        User mockedUser = mock(User.class);
        user1.connectFriend(mockedUser);
        verify(mockedUser).addFriend(user1);
        Assert.assertTrue(user1.isFriendOf(mockedUser));
    }

    @Test
    public void shouldCreateAddAndReturnAnEvent(){
        User user = anyUser().build();
        EventData eventData = new EventData("Test");
        Assert.assertEquals(user.createEvent(eventData).getTitle(), "Test");
    }

    @Test
    public void shouldAddAMusicGenreToTheProfile(){
        User user = anyUser().build();
        user.addMusicGenre(JAZZ);
        Assert.assertTrue(user.likeMusicalGenre(JAZZ));
    }

    @Test
    public void shouldRemoveAMusicalGenreFromTheProfile(){
        User user = anyUser().build();
        user.addMusicGenre(JAZZ);
        user.removeMusicalGenre(JAZZ);
        Assert.assertFalse(user.likeMusicalGenre(JAZZ));
    }

    @Test
    public void shouldAddAMovieGenreToTheProfile(){
        User user = anyUser().build();
        user.addMovieGenre(ACTION);
        Assert.assertTrue(user.likeMovieGenre(ACTION));
    }

    @Test
    public  void shouldRemoveAMovieGenreFromTheProfile(){
        User user = anyUser().build();
        user.addMovieGenre(ACTION);
        user.removeMovieGenre(ACTION);
        Assert.assertFalse(user.likeMovieGenre(ACTION));
    }

    @Test
    public void shouldAddAFoodTypeToTheProfile(){
        User user = anyUser().build();
        user.addFoodType(CHINESE);
        Assert.assertTrue(user.likeFoodType(CHINESE));
    }

    @Test
    public void shouldRemoveAFoodTypeFromTheProfile(){
        User user = anyUser().build();
        user.addFoodType(CHINESE);
        user.removeFoodType(CHINESE);
        Assert.assertFalse(user.likeFoodType(CHINESE));
    }

    @Test
    public void shouldSetAnAmountToTheProfile(){
        User user = anyUser().build();
        user.setAmount(500);
        Assert.assertEquals(user.getMaxAmount(), 500);
    }

    @Test
    public void shouldCreateIndividualPlan(){
        User user = anyUser().build();
        Individual plan = user.createIndividualPlan();
        Assert.assertTrue(user.hasPlanning(plan));
    }

    @Test
    public void shouldCreateCouplePlan(){
        User user = anyUser().build();
        Couple plan = user.createCouplePlan();
        Assert.assertTrue(user.hasPlanning(plan));
    }

    @Test
    public void shouldCreateWithFriendsPlan(){
        User user = anyUser().build();
        WithFriends plan = user.createWithFriendsPlan();
        Assert.assertTrue(user.hasPlanning(plan));
    }

    @Test
    public void shouldInviteAFriendToAPlanning(){
        User user = anyUser().build();
        User friend = anyUser().build();
        WithFriends plan = user.createWithFriendsPlan();
        Invitation invitation = user.inviteFriendTo(plan, friend);
        Assert.assertTrue(friend.hasInvitation(invitation));
    }

    @Test
    public void shouldAcceptTheInvitation(){
        User user = anyUser().build();
        Invitation mockedInvitation = mock(Invitation.class);
        user.acceptInvitationTo(mockedInvitation);
        verify(mockedInvitation).accept(user);
    }

}
