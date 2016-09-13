package model;

import model.events.EventData;
import model.plannings.Couple;
import model.plannings.Individual;
import model.plannings.WithFriends;
import model.users.Invitation;
import model.users.User;
import org.joda.time.LocalDate;
import org.junit.Assert;
import org.junit.Test;
import static model.users.FoodType.*;
import static model.users.MovieGenre.*;
import static model.users.MusicalGenre.*;
import static model.builders.UserBuilder.anyUser;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

public class UserTest {

    @Test
    public void shouldAddAFriend(){
        User userX = anyUser().withName("name").build();
        User userY = anyUser().with(userX).build();
        assertTrue(userY.isFriendOf(userX));
    }

    @Test
    public void shouldAddAPlanning(){
        User user = anyUser().withLastName("lastname").build();
        Individual planIndividual = mock(Individual.class);
        user.addPlanning(planIndividual);
        assertTrue(user.getPlannings().contains(planIndividual));
    }

    @Test
    public void shouldConnectFriend(){
        User user1 = anyUser().with(LocalDate.now()).build();
        User mockedUser = mock(User.class);
        user1.connectFriend(mockedUser);
        verify(mockedUser).addFriend(user1);
        assertTrue(user1.isFriendOf(mockedUser));
    }

    @Test
    public void shouldCreateAddAndReturnAnEvent(){
        User user = anyUser().withUserName("username").build();
        EventData eventData = new EventData("Test");
        assertEquals("Test", user.createEvent(eventData).getTitle());
    }

    @Test
    public void shouldAddAMusicGenreToTheProfile(){
        User user = anyUser().build();
        user.addMusicGenre(JAZZ);
        assertTrue(user.likeMusicalGenre(JAZZ));
    }

    @Test
    public void shouldRemoveAMusicalGenreFromTheProfile(){
        User user = anyUser().build();
        user.addMusicGenre(JAZZ);
        user.removeMusicalGenre(JAZZ);
        assertFalse(user.likeMusicalGenre(JAZZ));
    }

    @Test
    public void shouldAddAMovieGenreToTheProfile(){
        User user = anyUser().build();
        user.addMovieGenre(ACTION);
        assertTrue(user.likeMovieGenre(ACTION));
    }

    @Test
    public  void shouldRemoveAMovieGenreFromTheProfile(){
        User user = anyUser().build();
        user.addMovieGenre(ACTION);
        user.removeMovieGenre(ACTION);
        assertFalse(user.likeMovieGenre(ACTION));
    }

    @Test
    public void shouldAddAFoodTypeToTheProfile(){
        User user = anyUser().build();
        user.addFoodType(CHINESE);
        assertTrue(user.likeFoodType(CHINESE));
    }

    @Test
    public void shouldRemoveAFoodTypeFromTheProfile(){
        User user = anyUser().build();
        user.addFoodType(CHINESE);
        user.removeFoodType(CHINESE);
        assertFalse(user.likeFoodType(CHINESE));
    }

    @Test
    public void shouldSetAnAmountToTheProfile(){
        User user = anyUser().build();
        user.setAmount(500);
        assertEquals(500, user.getMaxAmount());
    }

    @Test
    public void shouldCreateIndividualPlan(){
        User user = anyUser().build();
        Individual plan = user.createIndividualPlan();
        assertTrue(user.hasPlanning(plan));
    }

    @Test
    public void shouldCreateCouplePlan(){
        User user = anyUser().build();
        Couple plan = user.createCouplePlan();
        assertTrue(user.hasPlanning(plan));
    }

    @Test
    public void shouldCreateWithFriendsPlan(){
        User user = anyUser().build();
        WithFriends plan = user.createWithFriendsPlan();
        assertTrue(user.hasPlanning(plan));
    }

    @Test
    public void shouldInviteAFriendToAPlanning(){
        User user = anyUser().build();
        User friend = anyUser().build();
        WithFriends plan = user.createWithFriendsPlan();
        Invitation invitation = user.inviteFriendTo(plan, friend);
        assertTrue(friend.hasInvitation(invitation));
    }

    @Test
    public void shouldAcceptTheInvitation(){
        User user = anyUser().build();
        User mockUser = mock(User.class);
        WithFriends mockPlan = mock(WithFriends.class);
        Invitation invitation = new Invitation(mockUser, mockPlan);
        user.acceptInvitationTo(invitation);
        assertTrue(invitation.isAccepted());
    }
}
