Feature: StringCalcService

  Scenario: Should sum digits in example string
    Given I initialize String Calc Service
    When I pass example string
    Then Value for example string is correct

  Scenario: Should sum given values
    Given I initialize String Calc Service
    When I pass value 23;333
    And I pass expected result 356
    Then The sum is correct

  Scenario: Should sum many numbers in string
    Given I initialize String Calc Service
    When I pass value 22;32;2;6;8
    And I pass expected result 70
    Then The sum is correct

  Scenario Outline: Should sum many given numbers
    Given I initialize String Calc Service
    When I pass value <value>
    And I pass expected result <expectedResult>
    Then The sum is correct
    Examples:
      | value               | expectedResult |
      | 1;2;3               | 6              |
      | 33;2                | 35             |
      | 23;15;23;14         | 75             |
      | 1234;4567;0930;4040 | 10771          |
      | ;                   | 0              |