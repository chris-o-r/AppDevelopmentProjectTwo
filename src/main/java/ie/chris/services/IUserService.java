package ie.chris.services;

import java.util.List;

import ie.chris.domain.User;

public interface IUserService {
	User findUserById(int id);
	boolean deleteProjectById(int id);
	User findUserByEmail(String projectName);
	List<User> listUsersInAlphabeticalOrder(); 
	String findUserEmailById(int id);
	boolean saveUser(User user);
}
