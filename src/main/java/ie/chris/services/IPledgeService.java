package ie.chris.services;

import ie.chris.domain.Pledge;
import ie.chris.domain.Project;

public interface IPledgeService {
	boolean savePledge(Pledge pledge);
	int getNumProjectsForPledge(Project project);
}
