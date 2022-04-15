package projectManagement;

import java.util.ArrayList;

public class Activity {
	
	Project project;
	ArrayList<Developer> developers = new ArrayList<Developer>();
	String name;
	int start, end;

	public Activity(String name) {
		if (!name.equals("")) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Error: missing activity name");
		}
		
	}

	public Activity(String name, int start, int end) {
		this.name = name;
		this.start = start;
		this.end = end;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}
	
	public int getStart() {
		return start;
	}

	public void setStart(int start) {
		this.start = start;
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		this.end = end;
	}
	
	public void addDeveloperByInitials(String initials) {
		developers.add(ProjectApplication.getInstance().getDeveloperByInitials(initials));
	}

	public boolean hasDeveloperByInitials(String initials) {
		return developers.contains(ProjectApplication.getInstance().getDeveloperByInitials(initials));
	}

}
