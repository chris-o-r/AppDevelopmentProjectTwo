package ie.chris.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.chris.domain.Pledge;
import ie.chris.domain.Project;

public interface IPledgeDao extends JpaRepository<Pledge, Integer>{

	Pledge findById(int id); 
	List<Pledge> findAll();
	
}
