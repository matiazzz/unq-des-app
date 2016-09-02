package model;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class Event {
    private String title;
    private String description;
    private int price = 0;
    private String resume;
    private String address;
    private Date date;
    private int duration;
    private String img;
    private String facebook;
    private List<User> attendees = new ArrayList<User>();

    public Event(EventData eventData){
        title = eventData.title;
        description = eventData.description;
        price = eventData.price;
        resume = eventData.resume;
        address = eventData.address;
        date = eventData.date;
        duration = eventData.duration;
        img = eventData.img;
        facebook = eventData.facebook;
    }

    public void addAttendee(User user){
        attendees.add(user);
    }

    public boolean isActive(){
        Date today = Calendar.getInstance().getTime();
        return today.compareTo(date) < 0;
    }

    public boolean isInactive(){
        Date today = Calendar.getInstance().getTime();
        return today.compareTo(date) > 0;
    }
}
