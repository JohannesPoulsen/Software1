package projectManagement;

public class Project {
	
	protected static int idNumber = 1;
	String id;
	String name;
	Developer projectLeader;
	
	public Project() {
		this.id = DateServer.getYear().substring(2,4) + String.format("%04d", idNumber);
		idNumber++;
	}
	
	public Project(String name) {
		this.id = DateServer.getYear().substring(2,4) + String.format("%04d", idNumber);
		this.name = name;
		idNumber++;
	}
	
	public Project(Developer projectLeader) {
		this.id = DateServer.getYear().substring(2,4) + String.format("%04d", idNumber);
		this.projectLeader = projectLeader;
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
	
	
	
	

}
