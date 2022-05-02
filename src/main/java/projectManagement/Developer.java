package projectManagement;

import java.util.ArrayList;
import java.util.List;

public class Developer {

	String initials;
	private Activity vacancyActivity = new Activity("vacancy");
	private TimeRegister vacancy = new TimeRegister(vacancyActivity, this);
	private ArrayList<Activity> activities = new ArrayList<Activity>();
	private ArrayList<TimeRegister> timeRegisterList = new ArrayList<TimeRegister>();

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

	public TimeRegister getRegisteredTimeByActivity(Activity activity) {
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

	public void registerTime(double hours, Activity activity) {
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

	public double getTotalHours() {
		double totalHours = 0;
		for (TimeRegister timeRegister : timeRegisterList) {
			totalHours += timeRegister.getTime();
		}
		return totalHours;
	}

}
