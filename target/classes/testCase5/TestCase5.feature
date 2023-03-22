
@tag
Feature: Upload file

  @tag1
  Scenario Outline: Contact Us Form
    Given I Launch browser
    And I Navigate to <url>
    When Click Contact Us
    And Enter contact details <name>, <email>, <subject> and <message>
    And I Upload <file>
    And I Submit
    Then I verify <successMessage>

    Examples: 
      | url  | name | email  | subject | message | file | successMessage |
      | https://automationexercise.com/ | Louis | louis@automation.com | Test | TestCase_number_5_is_Ok| C:\\Users\\melek\\Downloads\\Upload_Test.docx | Success! Your details have been submitted successfully. |
      
