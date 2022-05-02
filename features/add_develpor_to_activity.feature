Feature: Add a developer to an activity
	Description: A developer is added to an activity
	Actors: All
	
Scenario: A developer is assigned to an activity
	Given there exists a project
  And the company has an employee with the initial "huba"
  And there is an activity with name "Database fix" stored in the project
  When a user assigns the developer with initials "huba" to the activity
  Then the developer with initials "huba" is assigned to the activity
    
Scenario: A developer is assigned to an activity twice
	Given there exists a project
  And the company has an employee with the initial "huba"
  And there is an activity with name "Database fix" stored in the project
  And "huba" is assigned to the activity
  When a user assigns the developer with initials "huba" to the activity
  Then the error message "Error: developer already assigned to this activity" is given

