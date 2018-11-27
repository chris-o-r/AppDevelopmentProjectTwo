package ie.chris.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ie.chris.domain.Pledge;
import ie.chris.domain.Project;

public interface IPledgeDao extends JpaRepository<Pledge, Integer>{

	Pledge findById(int id); 
	List<Pledge> findAll();
	
	@Query("SELECT count(p) FROM Pledge p where p.project.id =:projectId")
	int countPledgesForProject(@Param("projectId")int projectId);
	//@Query("SELECT p FROM Pledge p where p.project.id =: porjectId")
	List<Pledge> findByProjectId( int projectId);
	
}
