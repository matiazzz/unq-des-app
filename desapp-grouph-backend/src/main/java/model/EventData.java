package model;

import java.time.LocalDate;
import java.time.LocalTime;

public class EventData {

    public String title;
    public String description;
    public int price = 0;
    public String address;
    public LocalDate date;
    public LocalTime time;
    public int duration;

    public EventData(String title){this.title = title;}
    public EventData(LocalDate date) {this.date = date;}

    public EventData(String title, String description, int price, String address, LocalDate date, LocalTime time, int duration){
        this.title = title;
        this.description = description;
        this.price = price;
        this.address = address;
        this.date = date;
        this.time = time;
        this.duration = duration;
    }
}
