Feature: Leaves functionality test cases

  @web @leaves1
  Scenario: Employee user should be able to create a draft leave
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


  @web @leaves2
  Scenario: Employee should be able to create a request for the leaves
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
    And I click on the request leave and confirm button
    Then Validate that alert should be displayed with the "Request has been submitted" text


  @web @leaves3
  Scenario: Manager should be able to reject the leave request
    When I enter email "managerEmail" in logIn Screen
    And  I enter password "managerPassword" in logIn Screen
    And  I click on the login button
    And User landed to the quick access page
    And I select the approval menu in the left sidebar
    Then User landed to the reviewer listing page
    And Validate that URL contains "newLeavesRequestURL" text
    When I clicks on the first leave that required the approval
    And I clicks on the reject button in the right side-bar
    And Submit the leave rejection note|reason "Testing: leave rejection"
    Then Validate that alert should be displayed with the "Review step has been rejected." text
