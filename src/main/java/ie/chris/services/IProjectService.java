package ie.chris.services;

import java.util.List;

import ie.chris.domain.Project;

public interface IProjectService {
	Project findProject(int id);
	boolean deleteProject(int id);
	Project findByName(String projectName);
	List<Project> listInAlphabeticalOrder(); 
	String findProjectName(int id);
	void save(Project project);
}
