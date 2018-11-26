package ie.chris.services;

import java.util.List;

import ie.chris.domain.Project;
import ie.chris.domain.User;

public interface IProjectService {
	Project findProject(int id);
	boolean deleteProject(int id);
	boolean updatePledgedAmmount(double ammount, Project project);
	Project findByName(String projectName);
	List<Project> listInAlphabeticalOrder(); 
	List<Project> findProjectsByUser(User user);
	boolean save(Project project);
}
