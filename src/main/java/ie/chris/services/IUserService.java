package ie.chris.services;

import java.util.List;

import ie.chris.domain.User;

public interface IUserService {
	User findUserById(int id);
	User findUserByEmail(String projectName);
	User getCurrentUser();
	boolean deleteProjectById(int id);
	List<User> listUsersInAlphabeticalOrder(); 
	String findUserEmailById(int id);
	boolean saveUser(User user);
}
