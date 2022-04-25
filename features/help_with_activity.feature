Feature: Help with activity
	Desciption: A user requests help with activity
	Actors: All


Scenario: An activity is marked as needing help
	Given there exists a project
	And there is an activity with name "Database fix" stored in the project
  When the activity is marked as needing help
  Then the activity has been marked as needing help

Scenario: A developer helps with an activity
	Given there exists a project
	And there is an activity with name "Database fix" stored in the project
	And the activity is marked as needing help
	And the company has an employee with the initial "huba"
	And "huba" is not assigned to the activity
	When "huba" is assigned to the activity
	Then the activity is not marked as needing help
