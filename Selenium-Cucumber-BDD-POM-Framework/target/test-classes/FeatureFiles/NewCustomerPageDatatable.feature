@Regression
Feature: Add New Customer

  Background: 
    Given user opens the browser URL
    And user enters the username as "mngr660745"
    And user enters the password as "EmYqUgu"
    When user clicks on login button
    Then validate that user navigates to the homepage of the application

  Scenario: Create new customer using cucumber datatable
    Given user is on home page of the application
    And user clicks on new customer link
    When user enter customer details
      | cust_name | Padma      |
      | gender    | female     |
      | dob       | 10-10-1998 |
      | address   | Chennai    |
      | city      | Chennai    |
      | state     | TN         |
      | pin       |     600001 |
      | telephone | 9876543210 |
      | email     | dynamic    |
      | password  | bnmbnm     |
    When user clicks on submit button
    Then new customer will be created
    And user captures the customer id
    And user clicks on logout link
    And user closes the browser
