Feature: dashboard

  Background: Login with valid credentials
    Given User navigates to login page
    When User fills fields with given information
    Then User should see pop up message

  @Dashboard
  Scenario: add new dashboard
    When User opens ALL DASHBOARDS page
    And User adds a new dashboard with random test data
    Then User sees Add new widget button on the page

  @Dashboard
  Scenario: add new dashboard and find the name on the ALL DASHBOARDS page
    When User opens ALL DASHBOARDS page
    And User adds a new dashboard with random test data
    And User goes to ALL DASHBOARDS page
    Then User sees the correct name of added dashboard on the ALL DASHBOARDS page

  @Dashboard
  Scenario: add new dashboard and find the description on the ALL DASHBOARDS page
    When User opens ALL DASHBOARDS page
    And User adds a new dashboard with random test data
    And User goes to ALL DASHBOARDS page
    Then User sees the correct description of added dashboard on the ALL DASHBOARDS page

  @Dashboard
  Scenario: find dashboard with Search by name input
    When User opens ALL DASHBOARDS page
    And User adds a new dashboard with random test data
    And User goes to ALL DASHBOARDS page
    And User adds a few more dashboards with random data
    And User enters the name of the first dashboard with Search by name input
    Then User sees only first dashboard's name in the list

  @Dashboard
  Scenario: edit dashboard
    When User opens ALL DASHBOARDS page
    And User adds a new dashboard with random test data
    And User goes to ALL DASHBOARDS page
    And User replaces the dashboard name with new one
    Then User sees a modified name on the ALL DASHBOARDS page

  @Dashboard
  Scenario: delete dashboard
    When User opens ALL DASHBOARDS page
    And User adds a new dashboard with random test data
    And User goes to ALL DASHBOARDS page
    And User deletes dashboard
    Then User does not see the dashboard name on the ALL DASHBOARDS page

  @Dashboard
  Scenario: add widget
    When User opens ALL DASHBOARDS page
    And User adds a new dashboard with random test data
    And User adds widget with random data
    Then User sees the name of new widget on dashboard page

