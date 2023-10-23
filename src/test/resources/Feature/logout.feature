Feature: Logout account

  @Test
  Scenario: User can logout account
    Given The user is login
    When The user clicks on the logout option
    Then The user should be logged out

  @Test
  Scenario: User can not open the inventory page after logout
    Given The user is login
    When The user clicks on the logout option
    And The user go to the inventory page
    Then The user should get the error message
