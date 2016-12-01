package model.events;

import model.users.Profile;

import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

@Inheritance(strategy= InheritanceType.JOINED)
public abstract class EventType extends model.Entity {

    public abstract boolean compareTo(Profile profile);
    public abstract boolean possiblyLikes(Profile profile);
}
