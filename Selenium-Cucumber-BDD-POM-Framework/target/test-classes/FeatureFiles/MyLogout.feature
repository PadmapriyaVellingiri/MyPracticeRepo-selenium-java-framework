@sanity
Feature: Logout from application

  Background: 
    Given user opens the browser URL
    And user enters the username as "mngr660745"
    And user enters the password as "EmYqUgu"
    When user clicks on login button
    Then validate that user navigates to the homepage of the application

  Scenario: Successful logout from application
    When user clicks on logout link
    Then user should see logout confirmation alert
    And user accepts the alert
    Then user should be redirected to login page
    And user closes the browser
