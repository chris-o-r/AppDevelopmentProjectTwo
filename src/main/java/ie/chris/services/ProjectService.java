package ie.chris.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.chris.dao.IProjectDao;
import ie.chris.domain.Project;

@Service
public class ProjectService implements IProjectService{

	@Autowired 
	IProjectDao projectDao;
	
	@Override
	public Project findProject(int id) {
		if (projectDao.existsById(id)) {
			return projectDao.findById(id);
		}else {
			return null; 
		}
	}

	@Override
	public boolean deleteProject(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Project findByName(String projectName) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Project> listInAlphabeticalOrder() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String findProjectName(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void save(Project project) {
		if (project != null) {
			projectDao.save(project);
		}
		
	}
	
	
}
