package model.plannings;

import model.users.User;
import org.joda.time.LocalDate;

import java.util.ArrayList;
import java.util.List;

public class WithFriends extends Planning {

    private List<User> friends = new ArrayList<User>();

    public WithFriends(User owner, LocalDate creationDate) {
        this.owner = owner;
        this.date = creationDate;
    }

    @Override
    public void addUser(User user) {
        this.friends.add(user);
    }
}