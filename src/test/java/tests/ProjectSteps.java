package tests;

import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import projectManagement.Application;
import projectManagement.DateServer;
import projectManagement.Project;

public class ProjectSteps {
	
	private Project project;
	private Application application;
	
	
	public ProjectSteps(Application application) {
		this.application = application;
	}
	
	@Given("there is no other project already existing")
	public void there_is_no_other_project_already_existing() {
		assertTrue(application.projects.isEmpty());
	}
	

	@Given("the current year is {string}")
	public void the_current_year_is(String year) {
	    assertTrue(DateServer.getYear().equals(year));
	}
	
	@When("the user creates a project without giving it a title")
	public void the_user_creates_a_project_without_giving_it_a_title() {
	    application.createProject();
	}
	
	@Then("a project with the ID {string} is created")
	public void a_project_with_the_id_is_created(String id) {
	   assertTrue(application.projectExistsWithId(id));
	}

}

