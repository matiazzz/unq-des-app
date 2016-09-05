package model;

import java.util.Date;

public class EventData {
    String title;
    String description;
    int price = 0;
    String resume;
    String address;
    Date date;
    int duration;
    String img;
    String facebook;

    public EventData(String title){this.title = title;}
}
