package model.plannings;

import model.User;
import org.joda.time.LocalDate;

public class Individual extends Planning {

    public Individual(User owner, LocalDate creationDate) {
        this.owner = owner;
        this.date = creationDate;
    }

    /**
     * Is empty because an individual planning has only a user, the owner.
     * @param user
     */
    @Override
    public void addUser(User user) {}
}
