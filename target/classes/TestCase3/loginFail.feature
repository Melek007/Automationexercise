@tag
Feature: Login with email and password

  @tag2
  Scenario Outline: Login User with incorrect email and password
    Given user connect to home page <url>
    When user click on login button <expectedLoginMessage>
    And user enter incorrect email <wrongEmail>
    And user enter incorrect password <wrongPassword>
    And user click on login button
    Then  Verify error message <expectedErrorMessage>

    Examples: 
      | url  | expectedLoginMessage | wrongEmail  | wrongPassword | expectedErrorMessage |
      | https://automationexercise.com/ | Login to your account | m@m.com | cc | Your email or password is incorrect! |
