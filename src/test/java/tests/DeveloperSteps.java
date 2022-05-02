package tests;

import io.cucumber.java.en.Given;
import projectManagement.ProjectApplication;
import projectManagement.Developer;

public class DeveloperSteps {
	
	Developer developer;
	ProjectApplication application;
	
	public DeveloperSteps(ProjectApplication application) {
		this.application = application.getInstance();
	}
	
	
	@Given("the company has an employee with the initial {string}")
	public void the_company_has_an_employee_with_the_initial(String string) {
		if (!application.developers.contains(application.getDeveloperByInitials(string))) {
			developer = new Developer(string);
			application.developers.add(developer);
		}
	}

}
