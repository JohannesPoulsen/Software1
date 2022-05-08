package projectManagement;

import java.util.ArrayList;
import java.util.List;

public final class ProjectApplication {		//s216161

	private static ProjectApplication instance;

	public static ProjectApplication getInstance() { // Singleton af vores program
		if (instance == null) {
			instance = new ProjectApplication();
		}
		return instance;
	}

	// midlertidig test dev
	Developer tester1 = new Developer("huba");
	Developer tester2 = new Developer("joe");
	//
	public ArrayList<Developer> developers;

	private final ArrayList<Project> projects;

	public ProjectApplication() {
		projects = new ArrayList<Project>();
		developers = new ArrayList<Developer>();
		// til test af developer:
		developers.add(tester1);
		developers.add(tester2);
	}

	public void addProject(Project project) throws Exception {
		if (!doesProjectExist(project.getName())) {
			projects.add(project);
		} else {
			throw new Exception("Project with specified name already exists");
		}
	}

	public boolean projectExistsWithId(String id) { // checks whether a project exists with the specified id
		assert id != null && ProjectApplication.getInstance().projects != null : "precondition failed";
		for (Project p : projects) { // 1
			if (p.getId().equals(id)) { // 2
				assert projects.contains(getProjectById(id)) : "postcondition failed";
				return true;
			}
		}
		assert !projects.contains(getProjectById(id)) : "postcondition failed";
		return false; // 3
	}

	public boolean doesProjectExist(String name) { // checks whether a project exists with the specified name
		for (Project p : projects) {
			if (p.getName() != null && (p.getName().equals(name) && !p.getName().equals(""))) {
				return true;
			}
		}
		return false;
	}

	public Developer getDeveloperByInitials(String initials) {
		Developer developer = null;
		assert developers != null && initials != null : "Precondition";
		for (Developer d : developers) {// 1
			if (d.getInitials().equals(initials)) { // 2
				developer = d;
			}
		}
		assert developers.contains(developer) || developer == null : "Postcondition";
		return developer;
	}

	public void resetProjectId() { // Used when the id number of new projects needs to be reset
		Project.idNumber = 1;
	}

	public void clearProjects() { // Removes all current projects
		projects.clear();
	}

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjectLeaderByInitials(Project project, String initials) {
		project.setProjectLeader(getDeveloperByInitials(initials));
	}

	public Project getProjectById(String id) {
		Project project = null;
		assert id != null : "Precondition";
		for (Project p : projects) {
			if (p.getId().equals(id)) {
				project = p;
			}
		}
		assert projects.contains(project) || project == null : "Postcondition";
		return project;
	}

	public void endProject(Project project) {
		if (projects.contains(project)) {
			projects.remove(project);
		} else {
			throw new IllegalStateException("Project with specified ID does not exist");
		}
	}

}
