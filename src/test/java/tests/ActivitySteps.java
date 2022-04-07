package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import projectManagement.ProjectApplication;
import projectManagement.Activity;
import projectManagement.DateServer;
import projectManagement.Developer;
import projectManagement.Project;

public class ActivitySteps {
	
	ProjectApplication application;
	Project project;
	Activity activity;
	
	public ActivitySteps(ProjectApplication application) {
		this.application = application;
	}
	
	@Given("there exists a project")
	public void thereIsAProjectWithId() {
		project = new Project();
		try {
			application.addProject(project);
		} catch(Exception e) {
			e.getMessage();
		}
		assertTrue(application.getProjects().contains(project));
	}

	@When("an activity with name {string} is created in the project")
	public void anActivityWithNameIsCreatedInTheProjectWithId(String name) {
		activity = new Activity(name);
		project.addActivity(activity);
	}

	@Then("the activity with name {string} is stored within the project")
	public void theActivityWithNameIsStoredWithinTheProject(String name) {
		assertTrue(project.containsActivityWithName(name));
	}
	
	@When("an activity with name {string}, expected start week {int} and end week {int} is created in the project")
	public void anActivityWithNameExpectedStartWeekAndEndWeekIsCreatedInTheProject(String name, int start, int end) {
	    activity = new Activity(name, start, end);
	    project.addActivity(activity);
	}

	@Then("the activity with name {string}, expected start week {int} and end week {int} is stored within the project")
	public void theActivityWithNameExpectedStartWeekAndEndWeekIsStoredWithinTheProject(String name, int start, int end) {
		assertTrue(project.containsActivityWithName(name));
		assertTrue(project.getActivityByName(name).getStart() == start);
		assertTrue(project.getActivityByName(name).getEnd() == end);
	}
	
	

}
