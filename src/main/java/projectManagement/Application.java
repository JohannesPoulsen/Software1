package projectManagement;

import java.util.ArrayList;

public class Application {

	public ArrayList<Project> projects;
	
	public Application() {
		projects = new ArrayList<Project>();
	}

	public void createProject() {
		Project project = new Project();
		projects.add(project);
	}
	
	public boolean projectExistsWithId(String id) {
		for (Project p : projects) {
	    	if (p.getId().equals(id)) {return true;}
	    }
		return false;
	}

}
