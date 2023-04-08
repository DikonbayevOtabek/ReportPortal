Feature: Login

  Scenario: Login with valid credentials
    Given User navigates to login page
    When User fills fields with given information
    Then User should see pop up message

  Scenario: Login with invalid credentials
    Given  User navigates to login page
    When User fills username and password fields with invalid values
    Then User should not see pop up message

  Scenario: Login with empty credentials
    Given  User navigates to login page
    When User fills username and password fields with empty values
    Then User should not see pop up message