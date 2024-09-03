Feature: Login functionality test cases

  @web @login1
  Scenario: Positive - User should be login successfully by employee and manager credentials
    When I enter email "saad.saleem+a1@projectinertia.com" in logIn Screen
    And  I enter password "Abc123!@#qwerty" in logIn Screen
    And  I click on the login button
    And  Validate that URL contains "/Inertia/#dashboard" text
    When Landed to the dashboard and select the project "Test Project 1"
    When Click on the location icon
    And  Click on the location list
    And  Select BloodDraw and Load the data
    Then Validate side panel tabs should be displayed
    When Click on the add checklist button
#    And  Click on the add checklist option modal should be displayed
#    And  Select the "202040415 New Self Serve Checklsit 1" checklist option
#    And  Select the "All objects of this type" apply to option
#    Then Click on the add modal button and close the modal




