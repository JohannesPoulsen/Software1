package projectManagement;

import java.util.ArrayList;

public class Activity {
	
	Project project;
	ArrayList<Developer> developers = new ArrayList<Developer>();
	String name;
	
	public Activity(String name) {
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

}
