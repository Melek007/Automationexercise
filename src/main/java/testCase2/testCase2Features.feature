@tag
Feature: User Account

  @tag1
  Scenario Outline: Login User with correct email and password
    Given I Launch browser
    And I Navigate to <url>
    When I Click on Signup Login button
    And I Verify Login to your account <expectedText1> is visible
    And I Enter correct <emailAddress> and <password>
    And I Click login button
    And I Verify that Logged in as username <expectedText2> is visible
    And I Click Logout button
    Then I Verify that Automation Exercise is present
    And I Close browser

    Examples: 
      | url  | expectedText1 | emailAddress | password | expectedText2 |
      | https://automationexercise.com/ | Login to your account | marc@gmail.com | 123456 | Logged in as Marc |
