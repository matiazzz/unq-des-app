package model.builders;

import model.Invitation;
import model.events.Event;
import model.MusicalGenre;
import model.Profile;
import model.User;
import model.plannings.Planning;
import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UserBuilder {

    private String name;
    private String lastname;
    private LocalDate birthday;
    private String username;
    //private String password;
    private List<User> friends;
    private Profile profile;
    private List<Event> events;
    private List<Planning> plannings;
    private List<Invitation> invitations;

    public UserBuilder(){
        this.name = "NAME";
        this.lastname = "LASTNAME";
        this.birthday = LocalDate.now();
        this.username = "USERNAME";
        this.profile = ProfileBuilder.anyProfile().build();
        this.friends = new ArrayList<User>();
        this.events = new ArrayList<Event>();
        this.plannings = new ArrayList<Planning>();
        this.invitations = new ArrayList<Invitation>();
    }

    public static UserBuilder anyUser() {
        return new UserBuilder();
    }

    public User build(){
        User user = new User();
        user.setBirthday(this.birthday);
        user.setEvents(this.events);
        user.setFriends(this.friends);
        user.setInvitations(this.invitations);
        user.setName(this.name);
        user.setUsername(this.username);
        user.setLastname(this.lastname);
        user.setProfile(this.profile);
        user.setPlannings(plannings);
        return user;
    }

    public UserBuilder with(User friend){
        this.friends.add(friend);
        return this;
    }
}
