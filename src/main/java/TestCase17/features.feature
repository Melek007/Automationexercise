@tag
Feature: Cart

  @tag2
  Scenario Outline: Remove Products From Cart
    Given user connects to home page <url>
    When user adds product <product>
    And user checks the cart
    And user removes product
    Then verify that product is removed from the cart <expectedMessage>

    Examples: 
      | url  | product | expectedMessage  |
      | https://automationexercise.com/ | Sleeveless Dress | Cart is empty! |
