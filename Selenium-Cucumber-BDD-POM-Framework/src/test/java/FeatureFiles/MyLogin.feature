@smoke
Feature: login functionality for demo guru

  Scenario Outline: Validate login Functionality
    Given user opens the browser URL
    And user enters the username as "<uname>"
    And user enters the password as "<password>"
    When user clicks on login button
    Then validate that user navigates to the homepage of the application
    And user clicks on logout link
    And user closes the browser

    Examples: 
      | uname      | password |
      | mngr660745 | EmYqUgu  |
