package tests;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import projectManagement.Developer;
import projectManagement.ProjectApplication;

public class WhiteboxTests {
	ProjectApplication application = ProjectApplication.getInstance();
	
	//White box test for getDeveloperByInitials
	@Test
	public void testGetDeveloperByInitialsDataSetA() {
		application.developers = new ArrayList<Developer>();
		assertEquals(application.getDeveloperByInitials("huba"),null);
	}
	@Test
	public void testGetDeveloperByInitialsDataSetB() {
		application.developers = new ArrayList<Developer>();
		Developer developer = new Developer("joe");
		application.developers.add(developer);
		assertEquals(application.getDeveloperByInitials("huba"),null);
	}
	@Test
	public void testGetDeveloperByInitialsDataSetC() {
		application.developers = new ArrayList<Developer>();
		Developer developer = new Developer("huba");
		application.developers.add(developer);
		assertEquals(application.getDeveloperByInitials("huba"),developer);
	}
	
	

}
