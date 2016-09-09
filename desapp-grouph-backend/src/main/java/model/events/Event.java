package model.events;

import model.User;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class Event {

    private String title;
    private String description;
    private int price = 0;
    private String address;
    private LocalDate date;
    private LocalTime time;
    private int duration;

    private Set<User> attendees = new HashSet<User>();
    //private EventType type; TODO

    public Event(EventData eventData){
        title = eventData.title;
        description = eventData.description;
        price = eventData.price;
        address = eventData.address;
        date = eventData.date;
        duration = eventData.duration;
        time = eventData.time;
    }

    public void addAttendee(User user){
        attendees.add(user);
    }

    public boolean isActive(){
        LocalDate today = LocalDate.now();
        return today.isBefore(date) || today.isEqual(date);
    }

    public Set<Event> suggestions(){
        //TODO
        return null;
    }

    public String getTitle() {return title;}

    public boolean isGoing(User user) {
        return attendees.contains(user);
    }
}