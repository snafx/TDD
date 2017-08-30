Feature: Bank Account

  Scenario: Newly created user is visible in bank database
    Given I create new bank
    When I create new user
    And I add new user to bank
    Then User is present in bank database

  Scenario: I can create user and account, and they are present in bank database
    Given I create new bank
    When I create new user
    And I create new account
    And I add new user to bank
    And I add new user to account
    And I add account to bank
    Then User is present in bank database
    And Account is present in bank database
    And User is attached to account in bank database

  Scenario: I can list all accounts attached to given user
    Given I create new bank
    When I create new user with firstName Johnny and lastName Parufka and add it to bank
    And I create new user with firstName Mario and lastName Koczkodan and add it to bank
    And I create new account for user 0 and add it to bank
    And I create new account for user 1 and add it to bank
    And I create new account for user 0 and add it to bank
    Then User with id 0 is present in bank database
    And User with id 0 has 2 accounts
