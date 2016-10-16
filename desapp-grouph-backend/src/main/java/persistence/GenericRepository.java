package persistence;

import model.users.Profile;
import model.users.User;

import java.io.Serializable;
import java.util.List;

/**
 * Interface for generic DAO
 * 
 * @param <T>
 */
public interface GenericRepository<T> {

	void save(T entity);

	void delete(T entity);

	void update(T entity);

	void deleteById(Serializable id);

	int count();

	List<T> findAll();

	List<T> findByExample(T exampleObject);

	T findById(Serializable id);

}