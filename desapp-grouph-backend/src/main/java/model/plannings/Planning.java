package model.plannings;

import model.events.Event;
import model.User;
import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public abstract class Planning {
    protected User owner;
    protected LocalDate date;
    protected List<Event> events = new ArrayList<Event>();

    public abstract void addUser(User user);
}
