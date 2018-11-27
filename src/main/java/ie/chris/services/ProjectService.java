package ie.chris.services;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.hibernate.criterion.PropertyProjection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.chris.dao.IProjectDao;
import ie.chris.domain.Pledge;
import ie.chris.domain.Project;
import ie.chris.domain.User;

@Service
public class ProjectService implements IProjectService{

	@Autowired 
	IProjectDao projectDao;
	
	@Autowired
	IUserService userService;
	
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
			//Setting Status
			project.setStatus(true);
			//Setting Date
			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");  
			LocalDateTime now = LocalDateTime.now();
			project.setDateCreated(dtf.format(now));
			//Setting Current User
			//@ TODO Add Auth Code
			project.setCreator(userService.findUserById(2));
			//Saving the project
			projectDao.save(project);
			return true;
		}else {
			return res; 
		}	
	}

	@Override
	public boolean updatePledgedAmmount(double ammount, Project project) {
		if (project != null && ammount > 0 ) {
			double newAmmount = project.getCurrentAmmount() + ammount;
			projectDao.updateCurrentAmmount(project.getId(), newAmmount);
			project = findProject(project.getId());
			if (project.getCurrentAmmount() >= project.getGoal()) {
				project.setStatus(false);
				updateProjectStatus(project);
			}
		}
		return false;
	}
	
	@Override
	public boolean updateProjectInfo(Project project) {
		projectDao.updateProjectInfo(project.getId(), project.getInfo());
		return true;
	}
	
	public boolean updateProjectStatus(Project project) {
		projectDao.updateProjectStatus(project.getId(), project.getStatus());
		return true;
	}
	
}
