package model.events;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="Events")
public class Events extends model.Entity{
    private List<Event> events = new ArrayList<>();

    public Events() {}

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

    public void add(Event event){
        this.events.add(event);
    }

    public int size() {
        return this.events.size();
    }
}
