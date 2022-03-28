package projectManagement;

public class Project {
	
	private static int idNumber = 1;
	String id;
	String name;
	public Project() {
		this.id = DateServer.getYear().substring(2,4) + String.format("%04d", idNumber);
		
	}
	public Project(String name) {
		this.id = DateServer.getYear().substring(2,4) + String.format("%04d", idNumber);
		this.name = name;
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
	
	
	
	

}
