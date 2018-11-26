package ie.chris.services;

import java.util.List;

import org.hibernate.criterion.PropertyProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.chris.dao.IProjectDao;
import ie.chris.domain.Project;
import ie.chris.domain.User;

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
		return  projectDao.findAllByOrderByNameAsc();
	}
	
	@Override
	public List<Project> findProjectsByUser(User user){
		List<Project> projects = null;
		if (user != null) {
			projects = projectDao.findProjectByCreator(user);
		}
		return projects;
	}

	
	@Override
	public boolean save(Project project) {
		boolean res = false; 
		if (project != null) {
			projectDao.save(project);
			return true;
		}else {
			return res; 
		}	
	}

	@Override
	public boolean updatePledgedAmmount(double ammount, Project project) {
		if (project != null && ammount > 0 ) {
			projectDao.updateCurrentAmmount(project.getId(), ammount);
		}
		return false;
	}
	
	
}
