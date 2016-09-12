package model.events;

import model.users.Profile;

public abstract class EventType {
    public abstract boolean compareTo(Profile profile);
}
