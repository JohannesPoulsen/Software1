Feature: Create Project
	Description: A project is created
	Actors: All
	
Scenario: A first project is created
	Given there is no other project already existing
	And the current year is "2022"
	When the user creates a project without giving it a title
	Then a project with the ID "220001" is created
	
Scenario: A project with a title is created
	Given there is no other project with the title "Project 1"
	When the user creates a project with the title "Project 1"
	Then a project is created with the title "Project 1"
	
Scenario: Creating a project with an already existing project title
	Given the user creates a project with the title "Project 1"
	When the user creates a project with the title "Project 1"
	Then the error message "Project with specified name already exists" is given

Scenario: A project is created with a projectleader
	Given the company has an employee with the initial "huba"
	When a user creates a project with leader "huba"
	Then "huba" is the leader of the project
