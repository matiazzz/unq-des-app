package model.builders;

import model.plannings.Planning;
import model.users.Invitation;
import model.users.User;
import org.joda.time.LocalDate;

import static model.builders.UserBuilder.anyUser;

public class InvitationBuilder {

    private User owner = anyUser().build();
    private Planning planning;
    private LocalDate date = LocalDate.now();
    private Boolean accepted = false;

    public static InvitationBuilder anyInvitation(){
        return new InvitationBuilder();
    }

    public Invitation build(){
        return new Invitation(owner, planning);
    }

    public InvitationBuilder with(User owner){
        this.owner = owner;
        return this;
    }
}
