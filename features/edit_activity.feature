
Feature: Edit activity
  Description: An activity is edited
	Actors: All

Scenario: A developer is removed from an activity
  Given there exists a project
  And the company has an employee with the initial "huba"
  And there is an activity with name "Database fix" stored in the project
	And "huba" is assigned to the activity
	When "huba" is removed from the activity
	Then "huba" is not assigned to the activity

Scenario: A developer is removed from activity they are not assigned to
	Given there exists a project
  And the company has an employee with the initial "huba"
  And there is an activity with name "Database fix" stored in the project
  And "huba" is not assigned to the activity
  When "huba" is removed from the activity
  Then the error message "Error: developer not assigned to this activity" is given
  
Scenario: the start week is updated for an activity
	Given there exists a project
  And there is an activity with name "Database fix" stored in the project
  When the start week is changed to 5
  Then the start week of the activity is 5
  
Scenario: the end week is updated for an activity
	Given there exists a project
  And there is an activity with name "Database fix" stored in the project
  When the end week is changed to 7
  Then the end week of the activity is 7
  
Scenario: the start week is set as invalid week
	Given there exists a project
  And there is an activity with name "Database fix" stored in the project
  When the start week is changed to 0
  Then the error message "Error: invalid week number" is given
  
Scenario: the end week is set as invalid week
	Given there exists a project
  And there is an activity with name "Database fix" stored in the project
  When the end week is changed to 53
  Then the error message "Error: invalid week number" is given
  
Scenario: An expected hour usage is set in the activity
	Given there exists a project
  And there is an activity with name "Database fix" stored in the project
  When the expected hour usage of the activity is set to 50.5
  Then the expected hour usage of the activity is 50.5
  
Scenario: An activity is removed
	Given there exists a project
  And there is an activity with name "Database fix" stored in the project
  When the activity "Database fix" is removed from the project
  Then the activity "Database fix" is not in the project
