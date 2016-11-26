package model.builders;

import model.events.*;
import model.users.User;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

public class EventBuilder {

    private String title;
    private String description;
    private int price = 0;
    private Place place;
    private LocalDate date;
    private LocalTime time;
    private int duration;
    private Set<User> attendees;
    private EventType eventType;
    private String imgUrl;
    private boolean isImportant;

    public EventBuilder(){
        title = "TITLE";
        description = "DESCRIPTION";
        price = 0;
        place = new Place("PLACENAME", "PLACEADDRESS");
        date = LocalDate.now();
        time = LocalTime.now();
        duration = 0;
        attendees = new HashSet<>();
        imgUrl = "imgURl";
        isImportant = false;
    }

    public static EventBuilder anyEvent(){return new EventBuilder();}

    public Event build(){
        EventData eventData = new EventData(title, description, eventType, price, place, date, time, duration, imgUrl, isImportant);
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

    public EventBuilder with(EventType eventType) {
        this.eventType = eventType;
        return this;
    }

    public EventBuilder with(boolean isImportant) {
        this.isImportant = isImportant;
        return this;
    }

    public EventBuilder withTitle(String title) {
        this.title = title;
        return this;
    }

    public EventBuilder withDescription(String description) {
        this.description = description;
        return this;
    }

    public EventBuilder withImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
        return this;
    }

    public EventBuilder withDate(LocalDate date) {
        this.date = date;
        return this;
    }

    public EventBuilder withTime(LocalTime time) {
        this.time = time;
        return this;
    }

    public EventBuilder withPrice(int price) {
        this.price = price;
        return this;
    }

    public EventBuilder withPlace(Place place) {
        this.place = place;
        return this;
    }

    public EventBuilder withEventType(MusicEvent musicEvent) {
        this.eventType = musicEvent;
        return this;
    }
}
