package projectManagement;

import java.util.ArrayList;
import java.util.List;

public class Activity {

	Project project;
	ArrayList<Developer> developers = new ArrayList<Developer>();
	String name;
	int start, end;
	private double expectedHourUsage;
	private boolean needingHelp = false;

	public Activity(String name) {
		if (!name.equals("")) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Error: missing activity name");
		}

	}

	public Activity(String name, int start, int end) {
		if (!name.equals("")) {
			this.name = name;
		} else {
			throw new IllegalArgumentException("Error: missing activity name");
		}
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
		if (0 < start && start < 53) {
			this.start = start;
		} else {
			throw new IllegalArgumentException("Error: invalid week number");
		}
	}

	public int getEnd() {
		return end;
	}

	public void setEnd(int end) {
		if (0 < end && end < 53) {
			this.end = end;
		} else {
			throw new IllegalArgumentException("Error: invalid week number");
		}
	}

	public void addDeveloperByInitials(String initials) {
		if (!hasDeveloperByInitials(initials)) {
			developers.add(ProjectApplication.getInstance().getDeveloperByInitials(initials));
			if (needingHelp) {
				setNeedingHelp(false);
			}
		} else {
			throw new IllegalArgumentException("Error: developer already assigned to this activity");
		}
	}

	public boolean hasDeveloperByInitials(String initials) {
		return developers.contains(ProjectApplication.getInstance().getDeveloperByInitials(initials));
	}

	public List<Developer> getDevelopers() {
		return developers;
	}

	public void removeDeveloperByInitials(String initials) {
		if (hasDeveloperByInitials(initials)) {
			developers.remove(ProjectApplication.getInstance().getDeveloperByInitials(initials));
		} else {
			throw new IllegalArgumentException("Error: developer not assigned to this activity");
		}

	}

	public void setExpectedHourUsage(Double hours) {
		this.expectedHourUsage = hours;
	}

	public double getExpectedHourUsage() {
		return this.expectedHourUsage;
	}

	public boolean isNeedingHelp() {
		return needingHelp;
	}

	public void setNeedingHelp(boolean neddingHelp) {
		this.needingHelp = neddingHelp;
	}

}
