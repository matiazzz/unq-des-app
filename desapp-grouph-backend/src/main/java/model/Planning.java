package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public abstract class Planning {
    protected User owner;
    protected Date date;
    protected List<Event> events = new ArrayList<Event>();
}
