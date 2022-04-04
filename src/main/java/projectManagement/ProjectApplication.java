package projectManagement;

import java.util.ArrayList;


public class ProjectApplication {


	public ArrayList<Developer> developers;
	public ArrayList<Project> projects;

	
	public ProjectApplication() {
		projects = new ArrayList<Project>();
		developers = new ArrayList<Developer>();
	}

	public void addProject(Project project) throws Exception {
		if(!doesProjectExist(project.getName())) {
			projects.add(project);			
		}
		else {
			throw new Exception("Project with specified name already exists");
		}
	}
	
	public boolean projectExistsWithId(String id) {
		for (Project p : projects) {
	    	if (p.getId().equals(id)) {
	    		return true;
	    		}
	    }
		return false;
	}

	public boolean doesProjectExist(String name) {
			for (Project p : projects) {
				if (p.getName().equals(name)) {
					return true;
				}	
			}
		return false;
	}
	
	public Developer getDeveloperByInitials(String initials) {
		for (Developer d : developers) {
			if (d.getInitials().equals(initials)) {
				return d;
			}
		}
		return null;
	}
	
	public void resetProjectId() {
		Project.idNumber = 1;
	}
	

}
