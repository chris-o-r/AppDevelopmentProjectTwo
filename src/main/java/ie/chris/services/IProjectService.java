package ie.chris.services;

import java.util.List;

import ie.chris.domain.Project;
import ie.chris.domain.User;

public interface IProjectService {
	Project findProject(int id);
	boolean deleteProject(int id);
	boolean updatePledgedAmmount(double ammount, Project project);
	List<Project> listInAlphabeticalOrder(); 
	List<Project> findProjectsByUser(User user);
	boolean save(Project project);
	boolean updateProjectInfo(Project project);
	boolean updateProjectStatus(Project project);
	
}
