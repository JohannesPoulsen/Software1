Feature: Create activity
	Description: An activity is created
	Actors: All

Scenario: Create activity successfully
	Given there is a project with id 220001
	When an activity with name "Database fix" is created in the project with id 220001 
	Then the activity with name "Database fix" is stored within the project
	
Scenario: Create activity with expected start and end
	Given there is a project with id 220001
	When an activity with name "Database fix", expected start week 15 and end week 23 is created in the project with id 220001
	Then the activity with name "Database fix", expected start week 15 and end week 23 is stored within the project

Scenario: Create activity with no name
	Given there is a project with id 220001
	When an activity with no name is created in the project with id 220001
	Then the error message "Error: missing activity name" is given
	
Scenario: Create activity with expected hour usage
	Given there is a project with id 220001
	When an activity with name "Database fix", expected hour usage 50 is created in the project with id 220001
	Then the activity with name "Database fix", expected hour usage 50 is stored within the project
	
Scenario: Create activity with name of existing activity
	Given there is a project with id 220001
	And an activity with name "Database fix" is stored within the project
	When an activity with name "Database fix" is created in the project with id 220001
	Then the error message "Error: activity name in use" is given
	