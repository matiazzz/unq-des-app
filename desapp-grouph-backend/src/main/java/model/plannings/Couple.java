package model.plannings;

import model.users.User;
import org.joda.time.LocalDate;

public class Couple extends Planning {
    private User couple;

    public void setCouple(User couple) {
        this.couple = couple;
    }

    public Couple(User owner, LocalDate creationDate) {
        this.owner = owner;
        this.date = creationDate;
    }

    @Override
    public void addUser(User user) {
        if(! hasCouple()){
            this.setCouple(user);
        }
    }

    public boolean hasCouple(){
        return this.couple != null;
    }
}
