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
	//midlertidig test dev
	Developer tester1 = new Developer("huba");
	Developer tester2 = new Developer("joe");
	//
	public ArrayList<Developer> developers;
	
	
	private final ArrayList<Project> projects;


	public ProjectApplication() {
		projects = new ArrayList<Project>();
		developers = new ArrayList<Developer>();
		//til test af developer:
		developers.add(tester1);
		developers.add(tester2);
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
				if (p.getName().equals(name) && !p.getName().equals("")) {
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
	
	public void setProjectLeaderByInitials(Project project, String initials) {
		project.setProjectLeader(getDeveloperByInitials(initials));
	}

	public Project getProjectById(String id) {
		for (Project p : projects) {
	    	if (p.getId().equals(id)) {
	    		return p;
	    		}
	    }
		return null;
	}

	public void endProject(Project project) {
		if (projects.contains(project)) {
			projects.remove(project);
		} else {
			throw new IllegalStateException("Project with specified ID does not exist");
		}
	}
	

}
