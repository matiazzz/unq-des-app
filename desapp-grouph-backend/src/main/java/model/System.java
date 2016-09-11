package model;

import model.events.Event;
import org.joda.time.LocalDate;
//import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class System {

    public List<User> users = new ArrayList<User>();
    public List<Event> events = new ArrayList<Event>();

    public List<Event> cheapEvents(User user){
        return this.events.stream()
                .filter(event -> event.getPrice() <= user.getMaxAmount())
                .collect(Collectors.toList());
    }

    public List<Event> eventsWithFriends (User user) {
        return this.filterEvents(user.getProfile()).stream()
                .filter(event -> likeEvent(user.getFriends(), event))
                .collect(Collectors.toList());
    }

    public List<Event> filterEvents(Profile profile) {
        return this.events.stream()
                .filter(event -> event.compareTo(profile))
                .collect(Collectors.toList());
    }

    public boolean likeEvent(List<User> users, Event event){
        return users.stream()
                .anyMatch(user -> event.compareTo(user.getProfile()));
    }

    public List<Event> saturdayNightFever(User user, LocalDate date){
        return this.filterEvents(user.getProfile()).stream()
                .filter(event -> event.getDate().equals(date))
                .collect(Collectors.toList());
    }

}