package ie.chris.services;

import java.util.List;

import ie.chris.domain.Pledge;
import ie.chris.domain.Project;

public interface IPledgeService {
	boolean savePledge(Pledge pledge);
	int getNumProjectsForPledge(Project project);
	List<Pledge> findAll();
	List<Pledge> findAllPledgesByProjectId(int projectId);
}	
