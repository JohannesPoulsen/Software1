Feature: Register time

Scenario: Developer registers time to an activity
	Given there is a project with id 220001
	And an activity with name "Database fix" is stored within the project
	When a developer registers 4.0 hours on the activity
	Then the 4.0 registered hours is added to the developers registered time