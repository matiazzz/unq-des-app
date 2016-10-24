package model.events;

import model.users.Profile;
import model.users.User;
import org.joda.time.*;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Event")
public class Event extends model.Entity {

    private String title;
    @Column(length = 10000)
    private String description;
    private int price = 0;
    private String address;
    private LocalDate date;
    private LocalTime time;
    private int duration;
    private String urlImg;
    @ManyToMany
    private Set<User> attendees = new HashSet<>();
    @Column(length = 10000)
    private EventType type;

    public Event() {}

    public Event(EventData eventData){
        title = eventData.title;
        description = eventData.description;
        price = eventData.price;
        address = eventData.address;
        date = eventData.date;
        duration = eventData.duration;
        time = eventData.time;
        urlImg = eventData.urlImg;
        type = eventData.eventType;
    }

    public void addAttendee(User user){
        attendees.add(user);
    }

    public boolean isActive(){
        LocalDate today = LocalDate.now();
        return today.isBefore(date) || today.isEqual(date);
    }

    public boolean compareTo(Profile profile){
        return this.type.compareTo(profile);
    }

    public String getTitle() {return title;}

    public boolean isGoing(User user) {
        return attendees.contains(user);
    }

    public int getPrice() {
        return price;
    }

    public LocalDate getDate() { return date; }

    public LocalTime getTime() {
        return time;
    }

    public EventType getType(){
        return type;
    }

    public String getUrlImg() {
        return this.urlImg;
    }
}
