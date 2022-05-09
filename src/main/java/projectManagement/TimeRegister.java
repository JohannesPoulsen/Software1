package projectManagement;

public class TimeRegister { 	//s204399 an s214929
	// Keeps track of time registered to an activity for a given developer

	private Activity activity;
	private Developer developer;
	private double time = 0;

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
		if (this.time < 0) {
			this.time = 0;
		}
	}

	public double getTime() {
		return time;
	}

	public void setTime(double time) {
		this.time = time;
		if (this.time < 0) {
			this.time = 0;
		}
	}

}
