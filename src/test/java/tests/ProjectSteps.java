package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import projectManagement.ProjectApplication;
import projectManagement.DateServer;
import projectManagement.Developer;
import projectManagement.Project;


public class ProjectSteps {
	
	private Project project;
	private ProjectApplication application;
	private ErrorMessageHolder errorMessage;
	
	
	public ProjectSteps(ProjectApplication application, ErrorMessageHolder errorMessage) {
		this.application = application;
		this.errorMessage = errorMessage;
	}
	
	@Given("a project is created")
	public void aProjectIsCreated() {
		project = new Project();
		try {
			application.addProject(project);
		} catch(Exception e) {
			e.getMessage();
		}
		assertTrue(application.getProjects().contains(project));
	}
	
	@Then("the error message {string} is given")
	public void the_error_message_is_given(String string) {
		assertEquals(errorMessage.getErrorMessage(), string);
	}
	
	@Given("there is no other project already existing")
	public void there_is_no_other_project_already_existing() {
		application.getProjects().clear();
		assertTrue(application.getProjects().isEmpty());
		application.resetProjectId();
	}

	@Given("the current year is {string}")
	public void the_current_year_is(String year) {
	    assertTrue(DateServer.getYear().equals(year));
	}
	
	@When("the user creates a project without giving it a title")
	public void the_user_creates_a_project_without_giving_it_a_title() {
		project = new Project();
		try {
			application.addProject(project);
		} catch(Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}
	
	@Then("a project with the ID {string} is created")
	public void a_project_with_the_id_is_created(String id) {
	   assertTrue(application.projectExistsWithId(id));
	}
	
	@Given("there is no other project with the title {string}")
	public void there_is_no_other_project_with_the_title(String name) {
	    assertFalse(application.doesProjectExist(name));
	}

	@When("the user creates a project with the title {string}")
	public void the_user_creates_a_project_with_the_title(String name) {
		project = new Project(name);
		try {
			application.addProject(project);
		} catch(Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("a project is created with the title {string}")
	public void a_project_is_created_with_the_title(String name) {
		assertTrue(application.doesProjectExist(name));
	}

	@When("a user creates a project with leader {string}")
	public void a_user_creates_a_project_with_leader(String initials) {
	    project = new Project(application.getDeveloperByInitials(initials));
	    try {
			application.addProject(project);
		} catch(Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	    
	}

	@Then("{string} is the leader of the project")
	public void is_the_leader_of_the_project(String initials) {
	    assertEquals(project.getProjectLeader().getInitials(),initials);
	}
	
	@Given("there is a project with ID {string}")
	public void thereIsAProjectWithID(String ID) {
		application.getProjects().clear();
		assertTrue(application.getProjects().isEmpty());
		application.resetProjectId();
		project = new Project();
	    try {
			application.addProject(project);
		} catch(Exception e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	    assertTrue(application.projectExistsWithId(ID));
		
	}

	@When("the project with the ID {string} is marked as ended")
	public void theProjectWithTheIDIsMarkedAsFinished(String ID) {
		try {
			application.endProject(application.getProjectById(ID));
		} catch(IllegalStateException e) {
			errorMessage.setErrorMessage(e.getMessage());
		}
	}

	@Then("the project with ID {string} is deleted from the active projectlist")
	public void theProjectWithIDIsDeletedFromTheActiveProjectlist(String ID) {
	    assertFalse(application.projectExistsWithId(ID));
	}
	
	@Given("there is no project with the ID: {string}")
	public void thereIsNoProjectWithTheID(String ID) {
	    if (application.projectExistsWithId(ID)) {
	    	application.endProject(application.getProjectById(ID));
	    }
	    assertFalse(application.projectExistsWithId(ID));
	}
	
	@When("{string} is assigned as the project leader of the project")
	public void isAssignedAsTheProjectLeaderOfTheProject(String initials) {
	    project.setProjectLeader(application.getDeveloperByInitials(initials));
	}

	
	
	

}

