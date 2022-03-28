Scenario: A developer helps with an activity
    Given: there is a project with id 220001
    And: there is an activity with name "Database fix" stored in the project
    And: an activity is marked as "need help"
    When: the user asigns himself to help 
    Then: the developer is assigned to the activity

Scenario: A developer closes an activity
    Given: there is a project with id 220001
    And: there is an activity with name "Database fix" stored in the project
    When: a user closes/deletes an activity
    Then: the activity is closed/deleted?