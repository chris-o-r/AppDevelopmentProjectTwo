package ie.chris.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ie.chris.dao.IPledgeDao;
import ie.chris.domain.Pledge;
import ie.chris.domain.Project;
import ie.chris.domain.User;

@Service
public class PledgeService implements IPledgeService {

	@Autowired
	IPledgeDao pledgeDao;

	@Autowired
	UserService userService;

	@Autowired
	ProjectService projectService; 

	@Override
	public boolean savePledge(Pledge pledge) {
		Project pledgeProject = pledge.getProject();

		/*
		 *Checking to see if the user pledging created this project 
		 */
		boolean userOwnsProject = false;
		//@ TODO Change this with actual auth code 
		User user = userService.findUserById(1);
		if (user != null) {
			List<Project> projects = (List<Project>) projectService.findProjectsByUser(user);
			for(int i=0; i<projects.size(); i++) {

				Project project = projects.get(i); 
				if (project.getId() == pledgeProject.getId()) {
					userOwnsProject = true; 
					break;
				}

			}



			if (userOwnsProject == false) {
				pledgeDao.save(pledge);
				projectService.updatePledgedAmmount(pledge.getPledged(), pledge.getProject());
				return true;
			}
		}
		return false;
	}
	
	public List<Pledge> findAll() {
		return  pledgeDao.findAll(); 
	}
	
	public int getNumProjectsForPledge(Project project) {
		int res = 0; 
		if (project != null) {
			res = pledgeDao.countPledgesForProject(project.getId());
		}
		return res; 
	}
}
