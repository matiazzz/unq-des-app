package service;

import model.users.Profile;
import model.users.User;
import persistence.UserDAO;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

public class UserService extends GenericService<User> {

	private static final long serialVersionUID = -2932116622242535843L;

	private UserDAO userDAO;

	@Transactional
	public List<User> findByName(String name) { return this.userDAO.findByName(name); }

	@Transactional
	public List<User> findByUserName(String userName) { return this.userDAO.findByUserName(userName); }

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@Transactional
	public Profile getProfileByUserName(String userName){
		return this.userDAO.getProfileByUserUserName(userName);
	}

}
