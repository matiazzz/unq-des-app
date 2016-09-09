package model.builders;

import model.events.Event;
import model.events.EventData;
import model.User;
import model.events.EventType;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class EventBuilder {

    private String title;
    private String description;
    private int price = 0;
    private String address;
    private LocalDate date;
    private LocalTime time;
    private int duration;
    private Set<User> attendees;
    private EventType eventType;

    public EventBuilder(){
        title = "TITLE";
        description = "DESCRIPTION";
        price = 0;
        address = "ADDRESS";
        date = LocalDate.now();
        time = LocalTime.now();
        duration = 0;
        attendees = new HashSet<User>();
    }

    public static EventBuilder anyEvent(){return new EventBuilder();}

    public Event build(){
        EventData eventData = new EventData(title, description, eventType, price, address, date, time, duration);
        return new Event(eventData);
    }

    public EventBuilder withDateToday(){
        this.date = LocalDate.now();
        return this;
    }

    public EventBuilder withDateTomorrow(){
        this.date = LocalDate.now().plusDays(1);
        return this;
    }

    public  EventBuilder withDateYesterday(){
        this.date = LocalDate.now().minusDays(1);
        return this;
    }

}
