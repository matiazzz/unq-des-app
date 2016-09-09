package model;

import model.events.*;
import org.junit.Assert;
import org.junit.Test;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;

import static model.builders.ProfileBuilder.anyProfile;
import static model.builders.UserBuilder.anyUser;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.*;

public class SystemTest {

    @Test
    public void shouldFindTwoEvent(){
        User user = mock(User.class);
        when(user.getMaxAmount()).thenReturn(100);
        Event event1 = mock(Event.class);
        Event event2 = mock(Event.class);
        Event event3 = mock(Event.class);
        when(event1.getPrice()).thenReturn(500);
        when(event2.getPrice()).thenReturn(100);
        when(event3.getPrice()).thenReturn(80);
        System system = new System();
        system.events.add(event1);
        system.events.add(event2);
        system.events.add(event3);
        assertEquals(system.cheapEvents(user).size(), 2);
        verify(user, times(3)).getMaxAmount();
        verify(event1).getPrice();
        verify(event2).getPrice();
        verify(event3).getPrice();
    }

    @Test
    public void shouldReturnTheEventsThatTheUserLikes(){
        Event foodEvent = mock(Event.class);
        Event musicEvent = mock(Event.class);
        Event movieEvent = mock(Event.class);
        Profile profile = mock(Profile.class);
        when(foodEvent.compareTo(profile)).thenReturn(true);
        when(musicEvent.compareTo(profile)).thenReturn(false);
        when(movieEvent.compareTo(profile)).thenReturn(true);
        System system = new System();
        system.events.add(foodEvent);
        system.events.add(movieEvent);
        system.events.add(musicEvent);
        assertEquals(system.filterEvents(profile).size(), 2);
    }

    @Test
    public void shouldCompareAnEventWithUsersProfile(){
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        Profile profile1 = mock(Profile.class);
        Profile profile2 = mock(Profile.class);
        Event event = mock(Event.class);
        when(user1.getProfile()).thenReturn(profile1);
        when(user2.getProfile()).thenReturn(profile2);
        when(event.compareTo(profile1)).thenReturn(false);
        when(event.compareTo(profile2)).thenReturn(true);
        System system = new System();
        List<User> users = new ArrayList<User>();
        users.add(user1);
        users.add(user2);
        assertTrue(system.likeEvent(users, event));
    }

}
