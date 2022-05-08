package projectManagement;

import java.util.ArrayList;
import java.util.List;

public class Developer {

	String initials;
	private Activity vacancyActivity = new Activity("vacancy"); // activity to register vacation, sickness and more to
	private TimeRegister vacancy = new TimeRegister(vacancyActivity, this); // Tracks the time registered to vacancy
	private ArrayList<Activity> activities = new ArrayList<Activity>(); // All activities the developers is assigned to
	private ArrayList<TimeRegister> timeRegisterList = new ArrayList<TimeRegister>(); // Keeps track of time registered

	public Developer(String initials) {
		this.initials = initials;
		this.activities.add(vacancyActivity);
		this.timeRegisterList.add(vacancy);
	}

	public Activity getVacancyActivity() {
		return vacancyActivity;
	}

	public String getInitials() {
		return this.initials;
	}

	public void addActivity(Activity activity) {
		if (!activities.contains(activity)) {
			activities.add(activity);
		}
	}

	public boolean isAssignedToActivity(Activity activity) {
		return this.activities.contains(activity);
	}

	public List<Activity> getActivities() {
		return activities;
	}

	public TimeRegister getRegisteredTimeByActivity(Activity activity) { // returns registered time to given activity
		for (TimeRegister timeRegister : timeRegisterList) {
			if (timeRegister.getActivity() == activity) {
				return timeRegister;
			}
		}
		return null;
	}

	public boolean hasRegisteredTimeToActivity(Activity activity) {
		if (getRegisteredTimeByActivity(activity) != null) {
			return true;
		}
		return false;
	}

	public void removeTimeRegisterByActivity(Activity activity) {
		timeRegisterList.remove(getRegisteredTimeByActivity(activity));
	}

	public void registerTime(double hours, Activity activity) { // registers time to given activity. Creates new
																// TimeRegister object if no time has been registered
		hours = Math.round(hours * 10.0) / 10.0;
		if (!activities.contains(activity)) {
			throw new IllegalStateException("Error: developer not assigned to this activity");
		}
		if (!hasRegisteredTimeToActivity(activity)) {
			TimeRegister timeRegister = new TimeRegister(activity, this);
			addTimeRegister(timeRegister);
		}
		getRegisteredTimeByActivity(activity).add(hours);
	}

	private void addTimeRegister(TimeRegister timeRegister) {
		timeRegisterList.add(timeRegister);
	}

	public TimeRegister getVacancy() {
		return vacancy;
	}

	public Activity getActivityByName(String name) {
		for (Activity a : activities) {
			if (a.getName().equals(name)) {
				return a;
			}
		}
		return null;
	}

	public double getTotalHours() { // Computes the total hours worked for developer
		double totalHours = 0;
		for (TimeRegister timeRegister : timeRegisterList) {
			totalHours += timeRegister.getTime();
		}
		return totalHours;
	}

}
