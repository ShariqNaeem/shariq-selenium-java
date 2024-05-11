Feature: Leaves functionality test cases

  @web @login1
  Scenario: Employee user should be able to create/delete a draft leave
    When I enter email "employeeEmail" in logIn Screen
    And  I enter password "employeePassword" in logIn Screen
    And  I click on the login button
    And User landed to the quick access page
    And I clicks on the quick access - leaves card
    Then Validate that URL contains "leavesURL" text
    When I click on plus button for requesting the leave
    Then Validate that URL contains "newLeavesRequestURL" text
    And Request new leave modal should be displayed
    And Select a date for the request a leave
    Then Validate before and after leaves should be matched
    And I click on the save draft button
    Then Validate that alert should be displayed with the "Draft request has been created" text
    And I delete the draft leaves request
    Then Validate that alert should be displayed with the "Draft request has been deleted" text
