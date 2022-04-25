package tests;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import projectManagement.Application;
import projectManagement.Project;

public class Help_with_activity {

	private Project project;
	private Activity activity;
	private Application application;
	
	@Given("there is a project with id {String}")
	public void there_is_a_project_with_id(String id) {
		project = new Project();
	    application.addProject(project);
		assertTrue(application.projectExistsWithId(id));
	}
		
	@Given("there is an activity with name {String} stored in the project")
	public void there_is_an_activity_with_name_stored_in_the_project(String name) {
		activity = new Activity(name);
		project.addActivity(activity);
		assertTrue(project.activityExist(name));
	}
	
	@Given("the need help status is {boolean}")
	public void an_activity_is_need_help_status_is(boolean needHelp) {
		assertTrue(activity.needsHelp(needHelp));
	}
	
	@When("the user asigns {String} to help")
	public void the_user_asigns_himself_to_help(String developersName) {
		activity.developers.add(developersName);
	}
	
	@Then("the developer {String} is assigned to the activity")
	public void the_developer_is_assigned_to_the_activity(String developersName) {
		assertTrue(activity.developerWithNameExists(developersName));
	}
	
	
	
}
