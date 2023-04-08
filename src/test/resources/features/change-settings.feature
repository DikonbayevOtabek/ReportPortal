Feature: Change project settings

  Background: User is Logged In
    Given I navigate to the login page
    When I submit username and password
    Then I should be logged in

  @GeneralOptions @Settings
  Scenario: User can not change project name field
    When General project settings tab is opened
    Then Project name field have an attribute "disabled"

  @GeneralOptions @Settings
  Scenario: User can change launch inactivity timeout option
    When General project settings tab is opened
    Given Launch inactivity timeout option is set to "12 hours"
    Then Pop up successful message is present

  @PatternAnalysis @Settings
  Scenario: User can not copy pattern with max name value
    When Pattern-analysis settings tab is opened
    Given New pattern with max name value is created
    Then User can not copy created pattern

  @DefectTypes @Settings
  Scenario: User can create custom product bug group
    When Defect-types tab is opened
    Given Custom product bug group is created
    Then Created bug group is present