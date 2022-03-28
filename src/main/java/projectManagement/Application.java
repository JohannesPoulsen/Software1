package projectManagement;

import java.util.ArrayList;


public class Application {

	public ArrayList<Project> projects;
	
	public Application() {
		projects = new ArrayList<Project>();
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

}
