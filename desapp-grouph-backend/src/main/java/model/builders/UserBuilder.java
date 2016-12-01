package model.builders;

import model.events.Events;
import model.users.Invitation;
import model.events.Event;
import model.users.Profile;
import model.users.User;
import model.plannings.Planning;
import org.joda.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import static model.builders.ProfileBuilder.anyProfile;

public class UserBuilder {

    private int id;
    private String name;
    private String lastName;
    private LocalDate birthday;
    private String userName;
    private List<User> friends;
    private Profile profile;
    private Events events;
    private Events going;
    private List<Planning> plannings;
    private List<Invitation> invitations;

    public UserBuilder(){
        this.name = "NAME";
        this.lastName = "LASTNAME";
        this.birthday = LocalDate.now();
        this.userName = "USERNAME";
        this.profile = anyProfile().build();
        this.friends = new ArrayList<>();
        this.events = new Events();
        this.going = new Events();
        this.plannings = new ArrayList<>();
        this.invitations = new ArrayList<>();
    }

    public static UserBuilder anyUser() {
        return new UserBuilder();
    }

    public User build(){
        User user = new User();
        user.setBirthday(this.birthday);
        user.setMyEvents(this.events);
        user.setFriends(this.friends);
        user.setInvitations(this.invitations);
        user.setName(this.name);
        user.setUserName(this.userName);
        user.setLastName(this.lastName);
        user.setProfile(this.profile);
        user.setPlannings(plannings);
        user.setGoing(this.going);
        return user;
    }

    public UserBuilder with(User friend){
        this.friends.add(friend);
        return this;
    }

    public UserBuilder with(int id){
        this.id = id;
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

    public UserBuilder with(Profile profile) {
        this.profile = profile;
        return this;
    }

    public UserBuilder with(Invitation invitation) {
        this.invitations.add(invitation);
        return this;
    }

    public UserBuilder with(Planning planning) {
        this.plannings.add(planning);
        return this;
    }

    public UserBuilder with(Event event) {
        this.events.add(event);
        return this;
    }

    public UserBuilder withProfile(Profile profile) {
        this.profile = profile;
        return this;
    }
}
