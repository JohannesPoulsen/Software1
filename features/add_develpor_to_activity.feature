Feature: Add a developer to an activity
	Description: A developer is added to an activity
	Actors: All
	
Scenario: A developer is assigned to an activity
    Given: there is a project with id 220001
    And: there is an activity with name "Database fix" stored in the project
    When: a user assigns the developer on the activity
    Then: the developer is assigned on the activity

Scenario: A developer has too many activities already
    Given: a developer with initials "huba" is already assigned to 9 activities 
    When: "huba" is assigned to another project
    Then: the error message ""huba" has too many activities assigned at the moment"

Scenario: A developer can be assigned for more than 9 activities 
    Given: a developer with initials "huba" already is assigned for 9 activities
    When: "huba" already has 9 activities assigned
    And: "huba" is a super developer
    Then: "huba" is assigned for an activity