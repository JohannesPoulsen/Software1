package projectManagement;

import java.util.ArrayList;
import java.util.List;

public class Developer {

	String initials;
	private ArrayList<Activity> activities = new ArrayList<Activity>();

	public Developer(String initials) {
		this.initials = initials;
	}

	public String getInitials() {
		return this.initials;
	}

	public void addActivity(Activity activity) {
		activities.add(activity);
	}

	public boolean isAssignedToActivity(Activity activity) {
		return this.activities.contains(activity);
	}

	public List<Activity> getActivities() {
		return activities;
	}

}
