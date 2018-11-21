package ie.chris.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import ie.chris.domain.Project;

public interface IProjectDao extends JpaRepository<Project, Integer> {
	
	Project findById(int id);
	Project findProjectByName(String projectName); 
	List<Project> findAllByOrderByNameAsc();
	//List<Project> findAllProjects();  	
	
}
