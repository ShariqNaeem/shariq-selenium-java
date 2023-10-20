Feature: Login functionality test cases

  @web @login1
  Scenario: Standard user should be login successfully
    When I enter user name "standard_user" in logIn Screen
    And  I enter password "secret_sauce" in logIn Screen
    And  I click on the login button
    Then Validate that URL contains "inventory" text

  @web @login2
  Scenario: Locked user should not be able to login in the application
    When I enter user name "locked_out_user" in logIn Screen
    And  I enter password "secret_sauce" in logIn Screen
    And  I click on the login button
    Then Validate the login error "Epic sadface: Sorry, this user has been locked out." message