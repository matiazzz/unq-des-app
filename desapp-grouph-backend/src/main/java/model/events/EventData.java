package model.events;

import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class EventData {

    public String title;
    public String description;
    public int price = 0;
    public String address;
    public LocalDate date;
    public LocalTime time;
    public int duration;
    public EventType eventType;

    public EventData(String title){this.title = title;}

    public EventData(String title, String description, EventType eventType, int price, String address, LocalDate date, LocalTime time, int duration){
        this.title = title;
        this.description = description;
        this.price = price;
        this.address = address;
        this.date = date;
        this.time = time;
        this.duration = duration;
        this.eventType = eventType;
    }
}
