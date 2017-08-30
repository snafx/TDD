Feature: WriteService

  Scenario: Test pass for example name
    Given I create new write service
    When i pass example name
    Then result is correct

  Scenario: I get correct message for multiple names
    Given I create new write service
    When i pass example names
    Then result for multiple names is correct

  Scenario: I get correct message for given name
    Given I create new write service
    When i pass name Koczkodan
    Then result for defined name Koczkodan is correct

  Scenario Outline: I get correct message for given names
    Given I create new write service
    When i pass name <name>
    Then result for name <name> is <expectedResult>
    Examples:
      | name            | expectedResult              |
      | Szymon          | Hello, Szymon               |
      | Adam            | Hello, Adam                 |
      | Jan,Beata,Aneta | Hello, Jan, Beata and Aneta |
      | JOHN            | HELLO, JOHN!                |
      | null            | Hello, null                 |