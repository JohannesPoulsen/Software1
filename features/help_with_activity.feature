Scenario: A developer helps with an activity
    Given: there is a project with id 220001
    And: there is an activity with name "Database fix" stored in the project 
    And: the need help status is true
    When: the user asigns "Conr" to help 
    Then: the developer "Conr" is assigned to the activity

#Scenario: A developer closes an activity
    #Given: there is a project with id 220001
    #And: there is an activity with name "Database fix" stored in the project
    #When: a user closes an activity
    #Then: the activity is closeds