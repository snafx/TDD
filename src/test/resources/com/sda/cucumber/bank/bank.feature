Feature: Bank Account

  Scenario: Newly created user is visible in bank database
    Given I create new bank
    When I create new user
    And I add new user to bank
    Then User is present in bank database