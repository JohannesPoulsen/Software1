package projectManagement;

import java.util.ArrayList;
import java.util.function.BooleanSupplier;

public class Project {
	
	public static int idNumber = 1;
	String id;
	String name;
	Developer projectLeader;
	ArrayList<Activity> activities;
	
	public Project() {
		this.id = DateServer.getYear().substring(2,4) + String.format("%04d", idNumber);
		idNumber++;
		activities = new ArrayList<Activity>();
	}
	
	public Project(String name) {
		this.id = DateServer.getYear().substring(2,4) + String.format("%04d", idNumber);
		this.name = name;
		idNumber++;
		activities = new ArrayList<Activity>();
	}
	
	public Project(Developer projectLeader) {
		this.id = DateServer.getYear().substring(2,4) + String.format("%04d", idNumber);
		this.projectLeader = projectLeader;
		activities = new ArrayList<Activity>();
	}
	
	public String getId() {
		return this.id;
	}

	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Developer getProjectLeader() {
		return this.projectLeader;
	}
	
	public void setProjectLeader(Developer developer) {
		this.projectLeader = developer;
	}

	public void addActivity(Activity activity) {
		if (!containsActivityWithName(activity.getName())) {
			activities.add(activity);
		}
		else {
			throw new IllegalStateException("Error: activity name in use");
		}
	}

	public boolean containsActivityWithName(String name) {
		for (Activity a : activities) {
			if (a.getName().equals(name)){
				return true;
			}
		}
		return false;
	}
	
	public Activity getActivityByName(String name) {
		for (Activity a : activities) {
			if (a.getName().equals(name)) {
				return a;
			}
		}
		return null;
	}
	
	
	
	

}
