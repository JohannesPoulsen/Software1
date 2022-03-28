Feature: Add project leader
	Description: A project leader is added to a project
    Actors: All
	
Scenario: Add a project leader to an existing project
    Given: a project with id 220001 is created
    And: there is an employee with the initial: "huba"
    When: a user creates a project
    And: assigns "huba" as the project leader
    Then: "huba" is the leader of the project 

Scenario: Add a project leader to a project which already has a project leader
    Given: there is a project leader with the initial "huba" on the project
    When: the user assigns a project leader with the initial "hube"
    Then: the error message "Project already has a project leader" is given

