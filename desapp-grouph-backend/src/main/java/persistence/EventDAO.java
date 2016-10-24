package persistence;

import model.events.Event;

import java.util.List;

public class EventDAO extends HibernateGenericDAO<Event> implements GenericRepository<Event> {

    @Override
    protected Class<Event> getDomainClass() {
        return Event.class;
    }

    public List<Event> mostPopular() {
        //TODO
        return findAll();
    }
}
