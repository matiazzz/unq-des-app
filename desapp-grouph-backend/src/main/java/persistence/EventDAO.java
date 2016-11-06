package persistence;

import model.events.Event;
import model.events.MusicEvent;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate4.HibernateCallback;

import java.util.List;

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

}
