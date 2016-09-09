package model;

import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserBuilder {

    private String name;
    private String lastname;
    private LocalDate birthday;
    private String username;
    private String password;
    private List<User> friends;
    private Profile profile;
    private List<Event> events;
    private List<Planning> plannings;

    public UserBuilder(){
        this.name = "NAME";
        this.lastname = "LASTNAME";
        this.birthday = LocalDate.now();
        this.username = "USERNAME";
        this.password = "PASSWORD";
        this.profile = ProfileBuilder.anyProfile().build();
        this.friends = new ArrayList<User>();
        this.events = new ArrayList<Event>();
        this.plannings = new ArrayList<Planning>();
    }

    public static UserBuilder anyUser() {
        return new UserBuilder();
    }

    public User build(){
        return new User(name, lastname, birthday, username, password, profile, friends, events, plannings);
    }

    public UserBuilder with(User friend){
        this.friends.add(friend);
        return this;
    }

    public UserBuilder with(MusicalGenre genre){
        this.profile.addMusicalGenre(genre);
        return this;
    }

}
