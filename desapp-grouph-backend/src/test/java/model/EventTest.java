package model;

import model.events.Event;
import model.users.User;
import org.junit.Test;
import static model.builders.EventBuilder.anyEvent;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;

public class EventTest {

    @Test
    public void tomorrowsEventShouldBeActive(){
        Event event = anyEvent()
                .withDateTomorrow()
                .build();
        assertTrue(event.isActive());
    }

    @Test
    public void todaysEventShouldBeActive(){
        Event event = anyEvent()
                .withDateToday()
                .build();
        assertTrue(event.isActive());
    }

    @Test
    public void eventShouldNotBeActive(){
        Event event = anyEvent()
                .withDateYesterday()
                .build();
        assertFalse(event.isActive());
    }

    @Test
    public void shouldAddAnAttendee(){
        User mockedUser = mock(User.class);
        Event event = anyEvent().build();
        event.addAttendee(mockedUser);
        assertTrue(event.isGoing(mockedUser));
    }
}
