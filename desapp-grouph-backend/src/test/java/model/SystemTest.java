package model;

import model.events.*;
import model.users.Profile;
import model.users.User;
import org.joda.time.LocalDate;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    public void shouldReturnAllTheEventsOfaSpecificDay(){
        User user = mock(User.class);
        Profile profile = mock(Profile.class);

        Event event1 = mock(Event.class);
        Event event2 = mock(Event.class);
        Event event3 = mock(Event.class);

        System system = new System();
        system.events.add(event1);
        system.events.add(event2);
        system.events.add(event3);

        when(user.getProfile()).thenReturn(profile);

        when(event1.compareTo(profile)).thenReturn(true);
        when(event2.compareTo(profile)).thenReturn(true);
        when(event3.compareTo(profile)).thenReturn(true);

        when(event1.getDate()).thenReturn(LocalDate.now().plusDays(1));
        when(event2.getDate()).thenReturn(LocalDate.now());
        when(event3.getDate()).thenReturn(LocalDate.now().minusDays(1));

        assertEquals(system.saturdayNightFever(user, LocalDate.now()).size(), 1);
    }

    @Test
    public void shouldReturnEventsToGoWithFriends() {
        User user = mock(User.class);
        User friend1 = mock(User.class);
        User friend2 = mock(User.class);
        Profile profile = mock(Profile.class);
        Profile profile1 = mock(Profile.class);
        Profile profile2 = mock(Profile.class);
        Event event1 = mock(Event.class);
        Event event2 = mock(Event.class);
        Event event3 = mock(Event.class);

        when(user.getProfile()).thenReturn(profile);
        when(friend1.getProfile()).thenReturn(profile1);
        when(friend2.getProfile()).thenReturn(profile2);
        when(user.getFriends()).thenReturn(Arrays.asList(friend1, friend2));

        when(event1.compareTo(user.getProfile())).thenReturn(true);
        when(event2.compareTo(user.getProfile())).thenReturn(true);
        when(event3.compareTo(user.getProfile())).thenReturn(true);

        when(event1.compareTo(friend1.getProfile())).thenReturn(false);
        when(event2.compareTo(friend1.getProfile())).thenReturn(false);
        when(event3.compareTo(friend1.getProfile())).thenReturn(false);

        when(event1.compareTo(friend2.getProfile())).thenReturn(true);
        when(event2.compareTo(friend2.getProfile())).thenReturn(false);
        when(event3.compareTo(friend2.getProfile())).thenReturn(false);

        System system = new System();
        system.events.addAll(Arrays.asList(event1, event2, event3));

        int expectedEvents = 1;
        assertEquals(expectedEvents, system.eventsWithFriends(user).size());
        assertTrue(system.eventsWithFriends(user).contains(event1));
    }

    @Test
    public void shouldReturnEventToGoInCouple(){
        System system = new System();
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        Profile profile1 = mock(Profile.class);
        Profile profile2 = mock(Profile.class);
        Event event1 = mock(Event.class);
        Event event2 = mock(Event.class);
        Event event3 = mock(Event.class);
        when(user1.getProfile()).thenReturn(profile1);
        when(user2.getProfile()).thenReturn(profile2);
        when(event1.compareTo(user1.getProfile())).thenReturn(true);
        when(event2.compareTo(user1.getProfile())).thenReturn(true);
        when(event3.compareTo(user1.getProfile())).thenReturn(true);
        when(event1.compareTo(user2.getProfile())).thenReturn(true);
        when(event2.compareTo(user2.getProfile())).thenReturn(false);
        when(event3.compareTo(user2.getProfile())).thenReturn(true);
        system.events.addAll(Arrays.asList(event1, event2, event3));
        int expectedEventQuantity = 2;
        assertEquals(expectedEventQuantity, system.eventsWithCouple(user1, user2).size());
        assertTrue(system.eventsWithCouple(user1, user2).contains(event1));
        assertTrue(system.eventsWithCouple(user1, user2).contains(event3));
    }

    @Test
    public void shouldNotReturnEventToGoInCouple(){
        System system = new System();
        User user1 = mock(User.class);
        User user2 = mock(User.class);
        Profile profile1 = mock(Profile.class);
        Profile profile2 = mock(Profile.class);
        Event event1 = mock(Event.class);
        Event event2 = mock(Event.class);
        Event event3 = mock(Event.class);
        when(user1.getProfile()).thenReturn(profile1);
        when(user2.getProfile()).thenReturn(profile2);
        when(event1.compareTo(user1.getProfile())).thenReturn(true);
        when(event2.compareTo(user1.getProfile())).thenReturn(true);
        when(event3.compareTo(user1.getProfile())).thenReturn(true);
        when(event1.compareTo(user2.getProfile())).thenReturn(false);
        when(event2.compareTo(user2.getProfile())).thenReturn(false);
        when(event3.compareTo(user2.getProfile())).thenReturn(false);
        system.events.addAll(Arrays.asList(event1, event2, event3));
        assertTrue(system.eventsWithCouple(user1, user2).isEmpty());
    }
}
