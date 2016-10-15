package service;

import model.users.User;
import persistence.UserDAO;

public class UserService extends GenericService<User> {

	private static final long serialVersionUID = -2932116622242535843L;

	public UserService(){}

	public UserService(UserDAO dao){
		this.setRepository(dao);
	}

}
