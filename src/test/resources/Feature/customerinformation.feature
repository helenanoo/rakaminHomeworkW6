Feature: Testing customer information after clicking checkout

  @Test
  Scenario: Fill the information correctly
    Given User login with valid credentials
    When User add product to cart
    And User navigates to the cart page
    And User clicks checkout
    And User fills the first name, last name and zip code correctly
    And User clicks continue
    And User clicks finish
    Then The order is successfully placed
    
    @Test
    Scenario: Empty the information
    Given User login with valid credentials
    When User add product to cart
    And User navigates to the cart page
    And User clicks checkout
    And User clicks continue
    Then The error message should be appear
