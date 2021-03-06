package persistence;

import model.events.Event;
import model.users.Profile;
import model.users.User;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.joda.time.LocalDate;
import org.springframework.orm.hibernate4.HibernateCallback;
import java.util.List;
import java.util.stream.Collectors;

public class EventDAO extends HibernateGenericDAO<Event> implements GenericRepository<Event> {

    @Override
    protected Class<Event> getDomainClass() {
        return Event.class;
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> mostPopular() {
        return (List<Event>) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public List<Event> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Event.class);
                criteria.add(Restrictions.eq("isImportant", true));
                return criteria.list();
            }
        });
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> getFreeEvents(){
        return (List<Event>) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public  List<Event> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Event.class);
                criteria.add(Restrictions.eq("price", 0));
                return criteria.list();
            }
        });
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> getMusicEvents() {
        return (List<Event>) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public List<Event> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Event.class);
                //TODO
                return criteria.list();
            }
        });
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> search(String word) {
        return (List<Event>) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public List<Event> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Event.class);
                Criterion title = Restrictions.ilike("title", word, MatchMode.ANYWHERE);
                Criterion description = Restrictions.ilike("description", word, MatchMode.ANYWHERE);
                criteria.add(Restrictions.or(title, description));
                return criteria.list();
            }
        });
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> getTodayEvents() {
        return (List<Event>) this.getHibernateTemplate().execute(new HibernateCallback() {
            @Override
            public  List<Event> doInHibernate(final Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(Event.class);
                criteria.add(Restrictions.eq("date", LocalDate.now()));
                return criteria.list();
            }
        });
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> getWithCoupleEvents(User user) {
        return findAll(); //TODO
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> getSuprisedMeEvents(User user) {
        return findAll().stream()
                .filter(event -> user.possiblyLikes(event))
                .collect(Collectors.toList());
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
    public List<Event> getWithFriendsEvents(User user) {
        return filterEvents(findAll(), user.getProfile()).stream()
                .filter(event -> likeEvent(user.getFriends(), event))
                .collect(Collectors.toList());
    }

    public List<Event> filterEvents(List<Event> events, Profile profile) {
        return events.stream()
                .filter(event -> event.compareTo(profile))
                .collect(Collectors.toList());
    }

    public boolean likeEvent(List<User> users, Event event){
        return users.stream().anyMatch(user -> event.compareTo(user.getProfile()));
    }

}
