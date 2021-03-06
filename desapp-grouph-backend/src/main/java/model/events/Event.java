package model.events;

import model.users.Profile;
import model.users.User;
import org.hibernate.annotations.*;
import org.joda.time.*;

import javax.persistence.*;
import org.hibernate.annotations.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="Event")
public class Event extends model.Entity {

    private String title;
    @Column(length = 10000)
    private String description;
    private int price = 0;
    @Column(length = 10000)
    private Place place;
    private LocalDate date;
    private LocalTime time;
    private int duration;
    private String urlImg;
    @ManyToMany
    @LazyCollection(LazyCollectionOption.FALSE)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private Set<User> attendees = new HashSet<>();
    @Column(length = 10000)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private EventType type;
    private boolean isImportant;

    public Event() {}

    public Event(EventData eventData){
        title = eventData.title;
        description = eventData.description;
        price = eventData.price;
        place = eventData.place;
        date = eventData.date;
        duration = eventData.duration;
        time = eventData.time;
        urlImg = eventData.urlImg;
        type = eventData.eventType;
        isImportant = eventData.isImportant;
    }

    public void addAttendee(User user){
        attendees.add(user);
        user.addGoingEvent(this);
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

    public boolean isImportant() {
        return isImportant;
    }

    public void setImportant(boolean important) {
        this.isImportant = important;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Place getPlace() {
        return place;
    }

    public int getDuration() {
        return duration;
    }

    public Set<User> getAttendees() {
        return attendees;
    }

    public void setType(EventType type) {
        this.type = type;
    }

    public void setUrlImg(String urlImg) {
        this.urlImg = urlImg;
    }

}
