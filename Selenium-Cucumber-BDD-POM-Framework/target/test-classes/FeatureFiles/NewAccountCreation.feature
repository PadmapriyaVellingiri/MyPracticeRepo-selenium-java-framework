@Regression
Feature: New account creation

  Background: 
    Given user opens the browser URL
    And user enters the username as "mngr660745"
    And user enters the password as "EmYqUgu"
    When user clicks on login button
    Then validate that user navigates to the homepage of the application

  Scenario: Creating new account using customer id fetching from excel
    Given user is on home page of the application
    And user clicks on New Account link
    And user fetches testdata from excel
    And user enter the Customer ID 
  # And the user selects the account type
   And the user enters the initial deposit
   And the user clicks on the "Submit" button
   Then the account should be created successfully
   And the user should see the new account ID generated
   And user clicks on logout link
    And user closes the browser
