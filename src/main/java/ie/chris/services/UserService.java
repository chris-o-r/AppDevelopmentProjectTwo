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
	public User findUserByName(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<User> listUsersInAlphabeticalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findUserNameById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void saveUser(User user) {
		if (user != null) {
			userDao.save(user);
		}
	}
	
	
}
