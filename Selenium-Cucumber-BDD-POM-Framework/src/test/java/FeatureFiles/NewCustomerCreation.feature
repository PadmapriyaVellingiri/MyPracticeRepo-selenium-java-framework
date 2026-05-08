@sanity
Feature: Create a new customer

  Background: 
    Given user opens the browser URL
    And user enters the username as "mngr660745"
    And user enters the password as "EmYqUgu"
    When user clicks on login button
    Then validate that user navigates to the homepage of the application

  Scenario Outline: Create a new customer with all details
    Given user is on home page of the application
    And user clicks on new customer link
    And user enter customer name as "<cust_name>"
    And user selects the gender "<gender>"
    And user selects the dateofBirth as "<dob>"
    And user enters the address as "<address>"
    And user enters the state as "<state>"
    And user enters the city as "<city>"
    And user enters the pin as "<pin>"
    And user enters the telephone as "<telephone>"
    And user enters the email as email
    And user enters the "<password>"
    When user clicks on submit button
    Then new customer will be created
    And user captures the customer id
    And user clicks on logout link
    And user closes the browser

    Examples: 
      | cust_name | gender | dob        | address  | state | city     | pin    | telephone  | email         | password |
      | priya     | female | 10-10-1991 | new road | assam | newcity | 500120 | 9873213214 | abcd@gmail.com | zxcvb|
