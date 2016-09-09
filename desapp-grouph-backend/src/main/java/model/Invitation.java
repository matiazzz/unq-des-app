package model;

import model.plannings.Planning;
import org.joda.time.LocalDate;

public class Invitation {
    private User owner;
    private Planning planning;
    private LocalDate date;

    public Invitation(User owner, Planning planning){
        this.owner = owner;
        this.planning = planning;
        this.date = LocalDate.now();
    }

    public void accept(User user){
        this.planning.addUser(user);
        user.addPlanning(planning);
    }

    public Planning getPlanning() {
        return planning;
    }
}
