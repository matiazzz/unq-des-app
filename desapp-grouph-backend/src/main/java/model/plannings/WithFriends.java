package model.plannings;

import model.users.User;
import org.joda.time.LocalDate;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="WithFriends")
public class WithFriends extends Planning {

    @OneToMany(fetch = FetchType.EAGER)
    private List<User> friends = new ArrayList<>();

    public WithFriends() {}

    public WithFriends(User owner, LocalDate creationDate) {
        this.owner = owner;
        this.date = creationDate;
    }

    @Override
    public void addUser(User user) {
        this.friends.add(user);
    }
}