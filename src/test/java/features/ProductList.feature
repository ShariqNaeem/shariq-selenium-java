Feature: Product Listing functionality test cases

  @web @plp1
  Scenario: User should able to add the product into the cart
    When I enter user name "standard_user" in logIn Screen
    And  I enter password "secret_sauce" in logIn Screen
    And  I click on the login button
    Then Validate that URL contains "inventory" text
    When I click on the back pack add to cart button
    Then Validate the count "1" on the cart icon


  @web @plp2
  Scenario: User should remove the product from listing page
    When I enter user name "standard_user" in logIn Screen
    And  I enter password "secret_sauce" in logIn Screen
    And  I click on the login button
    Then Validate that URL contains "inventory" text
    When I click on the back pack add to cart button
    And  I click on the back pack remove button
    Then Validate count "1" should remove on the cart icon