Feature: End Project
	Description: A project is finished
	Actors: All
	
Scenario: A project is removed based on ID
	Given there is a project with ID 220001
    When the project with the ID 220001 is marked as finished
    Then the project with ID 220001 is deleted from the active projectlist
    
Scenario: A project is removed based on title
    Given there is a project with the title: "Project 1"
    When the project with the title: "Project 1" is marked as finished
    Then the project with the name "Project 1" is deleted from the active projectlist
    
Scenario: Deleting a project that doesn't exist
    Given there is no project with the title: "Project 1"
    When the project with the title: "Project 1" is marked as finished
    Then the error message: "Project with specified name doesn't exist" is given   