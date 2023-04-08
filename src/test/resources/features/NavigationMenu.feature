Feature: Navigation Menu Tests

  Background: Login with valid credentials
    Given User navigates to login page

  Scenario: Launches Page Check
    When User navigates to Launches page
    Then User should find All launches button

  Scenario: Debug Page check
    When User navigates to Debug page
    Then User should product bug tab
