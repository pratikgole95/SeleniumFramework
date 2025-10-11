@Login
Feature: Login functionality

  Scenario: Valid login
    Given user is on login page
    When user enters valid credentials
    Then user should be redirected to home page