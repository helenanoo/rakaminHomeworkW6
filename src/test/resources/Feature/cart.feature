Feature: Testing Cart Add and Remove

  @Test
  Scenario: Add Items Into the Cart
    Given User login
    When The user adds an item to the cart
    Then The cart should contain the added item

  Scenario: Remove Items Into the Cart
    Given User login
    When The user adds an item to the cart
    And The user removes an item from the cart
    Then The product should be remove from the cart
    
    Scenario: User Checkout on Empty Cart
    Given User login
    When The user navigates to the cart page
    And The user click checkout button
    Then The error message should appear