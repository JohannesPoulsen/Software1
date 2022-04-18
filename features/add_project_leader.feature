Feature: Add project leader
	Description: A project leader is added to a project
    Actors: All
	
Scenario: Add a project leader to an existing project
	Given a project is created
  And the company has an employee with the initial "huba"
  When "huba" is assigned as the project leader of the project
  Then "huba" is the leader of the project 

Scenario: Change project leader of project
	Given a project is created
	And the company has an employee with the initial "huba"
  And "huba" is the project leader of the project
	And the company has an employee with the initial "soku"
  When "soku" is assigned as the project leader of the project
  Then "soku" is the leader of the project 

