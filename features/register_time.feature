Feature: Register time
	Description: A user registers time to an activity
	Actors: All
	
Scenario: A user registers time to an activity
	Given there exists a project
  And the company has an employee with the initial "huba"
  And an activity with name "Database fix" is stored within the project
  When a user assigns the developer with initials "huba" to the activity
  Then "huba" has the activity in his activity list
  


