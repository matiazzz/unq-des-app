package model.events;

import model.users.Profile;

public abstract class EventType {
    public abstract boolean compareTo(Profile profile);

    public abstract boolean possiblyLikes(Profile profile);
}
