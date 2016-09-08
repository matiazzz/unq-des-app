package model;

import org.junit.Assert;
import org.junit.Test;

public class EventTest {

    @Test
    public void eventShouldBeActive(){
        Event event = EventBuilder.anyEvent()
                .whithDateTomorrow()
                .build();

        Assert.assertTrue(event.isActive());
    }

    @Test
    public void evetShouldBeActive(){
        Event event = EventBuilder.anyEvent()
                .withDateToday()
                .build();

        Assert.assertTrue(event.isActive());
    }

    @Test
    public  void eventShouldNotBeActive(){
        Event event = EventBuilder.anyEvent()
                .whithDateYesterday()
                .build();

        Assert.assertFalse(event.isActive());
    }


}
