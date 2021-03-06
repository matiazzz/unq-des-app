package model;

import model.events.Event;
import model.users.Profile;
import model.users.User;
import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class System {

    public List<User> users = new ArrayList<>();
    public List<Event> events = new ArrayList<>();

    public List<Event> cheapEvents(User user){
        return events.stream()
                .filter(event -> event.getPrice() <= user.getMaxAmount())
                .collect(Collectors.toList());
    }

    public List<Event> eventsWithFriends (User user) {
        return filterEvents(user.getProfile()).stream()
                .filter(event -> likeEvent(user.getFriends(), event))
                .collect(Collectors.toList());
    }

    public List<Event> filterEvents(Profile profile) {
        return events.stream()
                .filter(event -> event.compareTo(profile))
                .collect(Collectors.toList());
    }

    public boolean likeEvent(List<User> users, Event event){
        return users.stream()
                .anyMatch(user -> event.compareTo(user.getProfile()));
    }

    public List<Event> saturdayNightFever(User user, LocalDate date){
        return filterEvents(user.getProfile()).stream()
                .filter(event -> event.getDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Event> eventsWithCouple(User user1, User user2){
        return filterEvents(user1.getProfile()).stream()
                .filter(event -> event.compareTo(user2.getProfile()))
                .collect(Collectors.toList());
    }

    public List<Event> surprisedMe(User user){
        return events.stream()
                .filter(event -> user.possiblyLikes(event))
                .collect(Collectors.toList());
    }
}
