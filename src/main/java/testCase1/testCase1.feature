@tag
Feature: End-to-end test

  @tag2
  Scenario Outline: Register User
    Given User launches browser and navigates to home page <url>
    
    When User signs up with <firstName> and <mail>
    And User enters account informations <password> <day> <month> <year>
    And User scrolls down and selects checkbox
    And User fills <firstName> <lastName> <company> <address>
    And User selects <country>
    And User completes details <state> <city> <zipcode> <mobileNumber>
    And User scrolls down and click cearte account button
    
    Then User verify message <expectedText>
    And User clicks continue button

    Examples: 
      | url  | firstName | mail  | password | day | month | year | lastName | company | address | country | state | city | zipcode | mobileNumber | expectedText |
      | http://automationexercise.com | Marc | marcleclerc@mmmm1.com | 123456 | 14 | February | 1989 | Leclerc | QA_company | 20_Rue_X | Canada | state1 | city1 | 75000 | 0145678930 | ACCOUNT CREATED! |
