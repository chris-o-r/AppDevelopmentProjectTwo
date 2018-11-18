package ie.chris.services;

import java.util.List;

import ie.chris.domain.User;

public interface IUserService {
	User findUserById(int id);
	boolean deleteProjectById(int id);
	User findUserByName(String projectName);
	List<User> listUsersInAlphabeticalOrder(); 
	String findUserNameById(int id);
	void saveUser(User user);
}
