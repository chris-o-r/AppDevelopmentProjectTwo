package ie.chris.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.chris.domain.User;

public interface IUserDao extends JpaRepository<User, Integer>{

	User findById(int id); 
	User findByName(String name); 
	boolean existsById(int id);
}
