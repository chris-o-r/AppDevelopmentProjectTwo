package ie.chris.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ie.chris.domain.Project;
import ie.chris.domain.User;

public interface IProjectDao extends JpaRepository<Project, Integer> {
	
	Project findById(int id);
	Project findProjectByName(String projectName); 
	List<Project> findAllByOrderByNameAsc();
	//@Query("SELECT p FROM PROJECT p WHERE p.id = :userId")
	List<Project> findProjectByCreator(User user);
	@Modifying(clearAutomatically = true)
	@Transactional
	@Query("UPDATE Project project set project.currentAmmount =:currentAmmount where project.id =:projectId")
	void updateCurrentAmmount(@Param("projectId")int projectId, @Param("currentAmmount")double currentAmmount);
	
}
