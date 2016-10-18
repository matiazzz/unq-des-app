package model.plannings;

import model.users.User;
import org.joda.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="Individual")
public class Individual extends Planning {

    public Individual() {}

    public Individual(User owner, LocalDate creationDate) {
        this.owner = owner;
        this.date = creationDate;
    }

    @Override
    public void addUser(User user) {
        // Is empty because an individual planning has only a user, the owner.
    }
}
