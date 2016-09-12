package model.builders;

import model.Invitation;
import model.events.Event;
import model.Profile;
import model.User;
import model.plannings.Planning;
import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static model.builders.ProfileBuilder.anyProfile;

public class UserBuilder {

    private String name;
    private String lastName;
    private LocalDate birthday;
    private String userName;
    private List<User> friends;
    private Profile profile;
    private List<Event> events;
    private List<Planning> plannings;
    private List<Invitation> invitations;

    public UserBuilder(){
        this.name = "NAME";
        this.lastName = "LASTNAME";
        this.birthday = LocalDate.now();
        this.userName = "USERNAME";
        this.profile = anyProfile().build();
        this.friends = new ArrayList<>();
        this.events = new ArrayList<>();
        this.plannings = new ArrayList<>();
        this.invitations = new ArrayList<>();
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
        user.setUserName(this.userName);
        user.setLastName(this.lastName);
        user.setProfile(this.profile);
        user.setPlannings(plannings);
        return user;
    }

    public UserBuilder with(User friend){
        this.friends.add(friend);
        return this;
    }

    public UserBuilder withName(String name){
        this.name = name;
        return this;
    }
    public UserBuilder withLastName(String lastName){
        this.lastName = lastName;
        return this;
    }
    public UserBuilder with(LocalDate birthday){
        this.birthday = birthday;
        return this;
    }
    public UserBuilder withUserName(String userName){
        this.userName = userName;
        return this;
    }
}
