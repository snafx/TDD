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

  Scenario: I can deposit some money to account stored in bank
    Given I create new bank
    When I create new account
    And I add account to bank
    And I deposit 666 amount of money to account
    Then Account is present in bank database
    And Amount of money 666 is present in bank database

  Scenario: I can deposit multiple times to the same account
    Given I create new bank
    When I create new account
    And I add account to bank
    And I deposit 200 amount of money to account
    And I deposit 1100 amount of money to account
    And I deposit 550 amount of money to account
    And I deposit 325 amount of money to account
    And I deposit -2200 amount of money to account
    And I deposit 1200 amount of money to account
    Then Account is present in bank database
    And Amount of money 1175 is present in bank database

  Scenario: I can list sorted list of users by their balance
    Given I create new bank
    When I create new user with firstName Mario and lastName Koczkodan and add it to bank
    When I create new user with firstName Johnny and lastName Parufka and add it to bank
    When I create new user with firstName Anna and lastName Noga and add it to bank
    And I create new account for user 0 and add it to bank
    And I create new account for user 1 and add it to bank
    And I create new account for user 2 and add it to bank
    And I create new account for user 1 and add it to bank
    And I deposit 200 to account with id 0
    And I deposit 150 to account with id 1
    And I deposit 660 to account with id 2
    And I deposit 460 to account with id 1
    And I deposit 730 to account with id 1
    And I deposit 135 to account with id 0
    And I list sorted users by balance
    Then User with id 1 is on top of the sorted list






