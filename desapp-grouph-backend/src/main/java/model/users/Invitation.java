package model.users;

import model.plannings.Planning;
import org.joda.time.LocalDate;

import javax.persistence.*;

@Entity
@Table(name="Invitation")
public class Invitation extends model.Entity {

    private static final long serialVersionUID = 6716714837006810519L;
    @Column(length = 10000)
    private User owner;
    @Transient
    private Planning planning;
    private LocalDate date;
    private Boolean accepted;

    public Invitation(){

    }

    public Invitation(User owner, Planning planning){
        this.owner = owner;
        this.planning = planning;
        this.date = LocalDate.now();
        this.accepted = false;
    }

    public void accept(User user){
        this.planning.addUser(user);
        user.addPlanning(planning);
        this.accepted = true;
    }

    public Boolean isAccepted() {
        return accepted;
    }

    public User getOwner() {
        return owner;
    }

    public LocalDate getDate() {
        return date;
    }
}
