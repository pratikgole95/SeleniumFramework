@HomePage
Feature: Validate Home page

  Background:
    Given user is on login page
    When user enters valid credentials

#  Scenario: Validate Title of page
#    Then Title of page "Cogmento CRM"


  Scenario: Scroll down to the page and verify text
    Then scroll down the home page
