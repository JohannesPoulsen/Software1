package projectManagement;

import java.util.ArrayList;
import java.util.List;

public class Project {	//s216161 and s214929

	private static int idNumber = 1;
	private String id;
	private String name = "";
	private Developer projectLeader;
	private ArrayList<Activity> activities;

	public Project() {
		this.id = DateServer.getYear().substring(2, 4) + String.format("%04d", getIdNumber());
		activities = new ArrayList<Activity>();
	}

	public Project(String name) {
		this.id = DateServer.getYear().substring(2, 4) + String.format("%04d", getIdNumber());
		this.name = name;
		activities = new ArrayList<Activity>();
	}

	public Project(Developer projectLeader) {
		this.id = DateServer.getYear().substring(2, 4) + String.format("%04d", getIdNumber());
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
		} else {
			throw new IllegalStateException("Error: activity name in use");
		}
	}

	public boolean containsActivityWithName(String name) {
		for (Activity a : activities) {
			if (a.getName().equals(name)) {
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

	public List<Activity> getActivities() {
		return activities;
	}

	public void endActivityByName(String name) {
		activities.remove(getActivityByName(name));
	}

	public static int getIdNumber() {
		return idNumber;
	}

	public static void setIdNumber(int idNumber) {
		Project.idNumber = idNumber;
	}

}
