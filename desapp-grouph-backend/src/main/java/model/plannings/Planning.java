package model.plannings;

import model.events.Event;
import model.users.User;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

public abstract class Planning extends model.Entity {
    @Column(length = 10000)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    protected User owner;
    protected LocalDate date;
    @ManyToMany(fetch = FetchType.EAGER)
    protected List<Event> events = new ArrayList<>();

    public abstract void addUser(User user);

    public void setOwner(User owner) {
        this.owner = owner;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }

}
