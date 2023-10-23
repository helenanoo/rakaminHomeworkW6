Feature: User Login

  @Test
  Scenario: Successful login
    Given the user is on the saucedemo login page
    When the user enters valid username and password
    And clicks the login button
    Then the user should be logged in

  Scenario: Unsuccessful login
    Given the user is on the saucedemo login page
    When the user enters invalid username and password
    And clicks the login button
    Then the user should see an error message
