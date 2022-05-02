package projectManagement;

public class TimeRegister {
	
	Activity activity;
	Developer developer;
	double time = 0;
	
	public TimeRegister(Activity activity, Developer developer) {
		this.activity = activity;
		this.developer = developer;
	}

	public Activity getActivity() {
		return activity;
	}

	public void setActivity(Activity activity) {
		this.activity = activity;
	}

	public Developer getDeveloper() {
		return developer;
	}

	public void setDeveloper(Developer developer) {
		this.developer = developer;
	}

	public void add(Double hours) {
		this.time += hours;
	}

	public double getTime() {
		return time;
	}

}
