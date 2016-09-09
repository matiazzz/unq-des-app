package model;

import org.junit.Assert;
import org.junit.Test;
import static model.EventBuilder.anyEvent;
import static org.junit.Assert.assertTrue;
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
        Assert.assertFalse(event.isActive());
    }

    @Test
    public void shouldAddAnAttendee(){
        User mockedUser = mock(User.class);
        Event event = anyEvent().build();
        event.addAttendee(mockedUser);
        assertTrue(event.isGoing(mockedUser));
    }
}
