package projectManagement;

public class Project {
	
	private static int idNumber = 1;
	String id;
	
	public Project() {
		this.id = DateServer.getYear().substring(2,4) + String.format("%04d", idNumber);
		
	}
	
	public String getId() {
		return this.id;
	}
	
	
	
	

}
