package model;


import java.time.LocalDate;
import java.time.LocalTime;
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
    //private EventType type; TODO

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
        EventData eventData = new EventData(title, description, price, address, date, time, duration);
        return new Event(eventData);
    }

    public EventBuilder withDateToday(){
        this.date = LocalDate.now();
        return this;
    }

    public EventBuilder whithDateTomorrow(){
        this.date = LocalDate.now().plusDays(1);
        return this;
    }

    public  EventBuilder whithDateYesterday(){
        this.date = LocalDate.now().minusDays(1);
        return this;
    }

}