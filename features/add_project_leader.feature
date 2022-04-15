Feature: Add project leader
	Description: A project leader is added to a project
    Actors: All
	
Scenario: Add a project leader to an existing project
    Given a project is created
    And the company has an employee with the initial "huba"
    When "huba" is assigned as the project leader of the project
    Then "huba" is the leader of the project 

#Scenario Add a project leader to a project which already has a project leader
    #Given there is a project leader with the initial "huba" on the project
    #When the user assigns a project leader with the initial "hube"
    #Then the error message "Project already has a project leader" is given

