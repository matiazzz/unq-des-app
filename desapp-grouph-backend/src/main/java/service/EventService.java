package service;

import model.events.Event;
import org.springframework.transaction.annotation.Transactional;
import persistence.EventDAO;

import java.util.List;

public class EventService extends GenericService<Event> {

    private EventDAO eventDAO;

    @Transactional
    public List<Event> mostPopular() {
        return eventDAO.mostPopular();
    }

    public void setEventDAO(EventDAO eventDAO) {
        this.eventDAO = eventDAO;
    }

    @Transactional
    public List<Event> getAll() {
        return eventDAO.findAll();
    }

    @Transactional
    public int size() {
        return eventDAO.count();
    }

    @Transactional
    public List<Event> getMusicEvents() {
        return eventDAO.getMusicEvents();
    }

    @Transactional
    public Event getById(int idEvent) {
        return eventDAO.findById(idEvent);
    }

    @Transactional
    public List<Event> search(String word) {
        return eventDAO.search(word);
    }

    @Transactional
    public List<Event> getFreeEvents() { return eventDAO.getFreeEvents(); }

    @Transactional
    public List<Event> getWithFriendsEvents() { return eventDAO.getWithFriendsEvents(); }

    @Transactional
    public List<Event> getTodayEvents() { return eventDAO.getTodayEvents(); }

    @Transactional
    public List<Event> getWithCoupleEvents() { return eventDAO.getWithCoupleEvents(); }

    @Transactional
    public List<Event> getSuprisedMeEvents() { return eventDAO.getSuprisedMeEvents(); }

}
