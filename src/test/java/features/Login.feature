Feature: Login functionality test cases

  @web @login1
  Scenario Outline: Positive - User should be login successfully by employee and manager credentials
    When I enter email "<email>" in logIn Screen
    And  I enter password "<password>" in logIn Screen
    And  I click on the login button
    Then User landed to the quick access page
    And Validate that URL contains "<url>" text
    Examples:
      | email         | password         | url              |
      | employeeEmail | employeePassword | ess/quick-access |
      | managerEmail  | managerPassword  | ess/quick-access |

  @web @login2
  Scenario Outline: Negative - User should not be able to login in the application
    When I enter email "<email>" in logIn Screen
    And  I enter password "<password>" in logIn Screen
    And  I click on the login button
    Then Validate the login error "<error_login_message>" message
    Examples:
      | email        | password        | error_login_message                                  |
      | invalidEmail | invalidPassword | Invalid username/password. |
      | invalidEmail | managerPassword | Invalid username/password. |
      | managerEmail | invalidPassword | Invalid username/password. |