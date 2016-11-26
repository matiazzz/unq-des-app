package model.events;

import model.users.FoodType;
import model.users.MovieGenre;
import model.users.MusicalGenre;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

import java.util.List;

public class EventData {

    public String title;
    public String description;
    public int price = 0;
    public Place place;
    public LocalDate date;
    public LocalTime time;
    public int duration;
    public EventType eventType;
    public String urlImg;
    public boolean isImportant;

    public EventData(String title){this.title = title;}

    public EventData(String title, String description, EventType eventType,
                     int price, Place place, LocalDate date, LocalTime time,
                     int duration, String urlImg, Boolean isImportant) {
        this.title = title;
        this.description = description;
        this.price = price;
        this.place = place;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.eventType = eventType;
        this.urlImg = urlImg;
        this.isImportant = isImportant;
    }

}
