package model.events;

import model.Profile;

public abstract class EventType {
    public abstract boolean compareTo(Profile profile);
}
