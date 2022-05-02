Feature: Register time
	Description: A user registers time to an activity
	Actors: All
	
Scenario: A user has activity in activity list
	Given there exists a project
  And the company has an employee with the initial "huba"
  And an activity with name "Database fix" is stored within the project
  When a user assigns the developer with initials "huba" to the activity
  Then "huba" has the activity in his activity list

Scenario: A user registers time to an activity
	Given there exists a project
  And the company has an employee with the initial "huba"
  And an activity with name "Database fix" is stored within the project
  And "huba" is assigned to the activity
  And "huba" has no registered time to the activity
  When "huba" registers 4.5 hours to the activity
  Then 4.5 hours is registered to the activity for "huba"
  And the total hours for "huba" is 4.5

Scenario: A user registers time to vacancy
  Given the company has an employee with the initial "huba"
  And "huba" has no registered time to the vacancy
  When "huba" registers 4.5 hours to vacancy
  Then 4.5 hours is registered to vacancy for "huba"

Scenario: A user registers time to an activity twice
	Given there exists a project
  And the company has an employee with the initial "huba"
  And an activity with name "Database fix" is stored within the project
  And "huba" is assigned to the activity
  And "huba" has no registered time to the activity
  When "huba" registers 5.0 hours to the activity
  And "huba" registers 4.5 hours to the activity
  Then 9.5 hours is registered to the activity for "huba"
  
Scenario: A user registers time to an activity which they are not assigned to
	Given there exists a project
  And the company has an employee with the initial "huba"
  And an activity with name "Database fix" is stored within the project
  And "huba" has no registered time to the activity
  When "huba" registers 4.5 hours to the activity
  Then the error message "Error: developer not assigned to this activity" is given