package projectManagement;

import java.util.ArrayList;
import java.util.List;


public final class ProjectApplication {


	private static ProjectApplication instance;
	public static ProjectApplication getInstance() {
		if (instance == null) {
			instance = new ProjectApplication();
		}
		return instance;
	}
	public ArrayList<Developer> developers;
	
	private final ArrayList<Project> projects;


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

	public List<Project> getProjects() {
		return projects;
	}
	

}
