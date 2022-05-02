package projectManagement;

import java.util.ArrayList;
import java.util.List;

public class Developer {

	String initials;
	private ArrayList<Activity> activities = new ArrayList<Activity>();
	private ArrayList<TimeRegister> timeRegisterList = new ArrayList<TimeRegister>();

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
	
	public TimeRegister getRegisteredTimeByActivity(Activity activity) {
		for(TimeRegister timeRegister : timeRegisterList ) {
			if(timeRegister.getActivity() == activity) {
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

	public void registerTime(Double hours, Activity activity) {
		if (!hasRegisteredTimeToActivity(activity)) {
			TimeRegister timeRegister = new TimeRegister(activity, this);
			addTimeRegister(timeRegister);
		} 
		getRegisteredTimeByActivity(activity).add(hours);
	}

	private void addTimeRegister(TimeRegister timeRegister) {
		timeRegisterList.add(timeRegister);
	}

}
