
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