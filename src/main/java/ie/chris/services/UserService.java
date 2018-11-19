package ie.chris.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.chris.dao.IUserDao;
import ie.chris.domain.User;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserDao userDao; 
	
	@Override
	public User findUserById(int id) {
		if (userDao.existsById(id)) {
			return userDao.findById(id);
		}
		return null;
	}

	@Override
	public boolean deleteProjectById(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public User findUserByEmail(String email) {
		return userDao.findByEmail(email); 
	}

	@Override
	public List<User> listUsersInAlphabeticalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUserEmailById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean saveUser(User user) {
		//Rules Out Null Input
		if (user != null) {
			//Ensures the user does not already exist by that email
			if (findUserByEmail(user.getEmail()) == null) {
				//Creating the user
				userDao.save(user);
				return true;
			}
			return false;
		}
		return false;
	}
	
	
}
