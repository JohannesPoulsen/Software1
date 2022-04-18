Feature: End Project
	Description: A project is finished
	Actors: All
	
Scenario: A project is removed based on ID
		Given there is a project with ID "220001"
    When the project with the ID "220001" is marked as ended
    Then the project with ID "220001" is deleted from the active projectlist
   
Scenario: Deleting a project that does not exist
    Given there is no project with the ID: "220001"
    When the project with the ID "220001" is marked as ended
    Then the error message "Project with specified ID does not exist" is given   