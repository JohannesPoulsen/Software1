package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import projectManagement.Developer;
import projectManagement.Project;
import projectManagement.ProjectApplication;

public class WhiteboxTests {
	ProjectApplication application = ProjectApplication.getInstance();

	// White box test for getDeveloperByInitials
	@Test
	public void testGetDeveloperByInitialsDataSetA() {
		application.developers = new ArrayList<Developer>();
		assertEquals(application.getDeveloperByInitials("huba"), null);
	}

	@Test
	public void testGetDeveloperByInitialsDataSetB() {
		application.developers = new ArrayList<Developer>();
		Developer developer = new Developer("joe");
		application.developers.add(developer);
		assertEquals(application.getDeveloperByInitials("huba"), null);
	}

	@Test
	public void testGetDeveloperByInitialsDataSetC() {
		application.developers = new ArrayList<Developer>();
		Developer developer = new Developer("huba");
		application.developers.add(developer);
		assertEquals(application.getDeveloperByInitials("huba"), developer);
	}

	// Whitebox tests for projectExistsWithId
	@Test
	public void testProjectExistsWithIdDataSetA() {
		application.clearProjects();
		assertTrue(application.getProjects().isEmpty());
		assertFalse(application.projectExistsWithId("220002"));
	}

	@Test
	public void testProjectExistsWithIdDataSetB() throws Exception {
		application.clearProjects();
		assertTrue(application.getProjects().isEmpty());
		application.resetProjectId();
		Project project = new Project();
		application.addProject(project);
		assertEquals(project.getId(), "220001");
		assertFalse(application.projectExistsWithId("220002"));
	}

	@Test
	public void testProjectExistsWithIdDataSetC() throws Exception {
		application.clearProjects();
		assertTrue(application.getProjects().isEmpty());
		application.resetProjectId();
		Project project1 = new Project();
		Project project2 = new Project();
		application.addProject(project1);
		application.addProject(project2);
		assertEquals(project1.getId(), "220001");
		assertEquals(project2.getId(), "220002");
		assertTrue(application.projectExistsWithId("220002"));
	}

	// White box test for getProjectById
	@Test
	public void testGetProjectByIdDataSetA() {
		application.clearProjects();
		assertTrue(application.getProjects().isEmpty());
		assertEquals(application.getProjectById("220001"), null);

	}

	@Test
	public void testGetProjectByIdDataSetB() throws Exception {
		application.clearProjects();
		assertTrue(application.getProjects().isEmpty());
		application.resetProjectId();
		Project project = new Project();
		application.addProject(project);
		assertEquals(application.getProjectById("220002"), null);
	}

	@Test
	public void testGetProjectByIdDataSetC() throws Exception {
		application.clearProjects();
		assertTrue(application.getProjects().isEmpty());
		application.resetProjectId();
		Project project = new Project();
		application.addProject(project);
		assertEquals(application.getProjectById("220001"), project);

	}
		
		// White box test for doesProjectExist
		@Test
		public void testDoesProjectExistA() throws Exception {
			application.clearProjects();
			assertTrue(application.getProjects().isEmpty());
			Project project = new Project();
			application.addProject(project);
			assertFalse(application.doesProjectExist("testName"));
		}
		
		@Test
		public void testDoesProjectExistB() throws Exception {
			application.clearProjects();
			assertTrue(application.getProjects().isEmpty());
			Project project = new Project("testName");
			application.addProject(project);
			assertTrue(application.doesProjectExist("testName"));
		}
		
		@Test
		public void testDoesProjectExistC() throws Exception {
			application.clearProjects();
			assertTrue(application.getProjects().isEmpty());
			Project project = new Project("testName");
			application.addProject(project);
			assertFalse(application.doesProjectExist("notWorkingtestName"));
		}
		
		
	
}
