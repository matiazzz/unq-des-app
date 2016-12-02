package model.plannings;

import model.users.User;
import org.hibernate.annotations.*;
import org.hibernate.annotations.CascadeType;
import org.joda.time.LocalDate;

import javax.persistence.*;

public class Couple extends Planning {

    @Column(length = 10000)
    @Cascade({CascadeType.SAVE_UPDATE, CascadeType.DELETE})
    private User couple;

    public Couple() {}

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

    public void setCouple(User couple) {
        this.couple = couple;
    }

    public boolean hasCouple(){
        return this.couple != null;
    }
}
