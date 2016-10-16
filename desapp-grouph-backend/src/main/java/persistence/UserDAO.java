package persistence;

import model.users.User;

import java.util.List;

public class UserDAO extends HibernateGenericDAO<User> implements GenericRepository<User> {

    @Override
    protected Class<User> getDomainClass() {
        return User.class;
    }

    @SuppressWarnings("unchecked")
    public List<User> findByName(String name) {
        return (List<User>) this.getHibernateTemplate()
                .find("from User where name = ?", name);
    }

    @SuppressWarnings("unchecked")
    public List<User> findByUserName(String userName) {
        return (List<User>) this.getHibernateTemplate()
                .find("from User where userName = ?", userName);
    }
}
