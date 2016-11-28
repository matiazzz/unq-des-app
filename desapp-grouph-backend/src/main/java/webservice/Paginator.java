package webservice;

import model.events.Event;
import java.util.List;
import java.util.stream.Collectors;

public class Paginator {

    private List<Event> events;

    public Paginator(List<Event> events){
        this.events = events;
    }

    public List<Event> getPage(int page, int sizePage) {
        return events.stream().skip((page-1) * sizePage).limit(sizePage).collect(Collectors.toList());
    }
}
