Feature: Logout

  Background: : Login with valid credentials
    Given User navigates to login page
    When User fills fields with given information
    Then User should see pop up message

  Scenario: Logout from account
    When User clicks logout button through avatar pop up window
    Then User should see successfully logout pop up message