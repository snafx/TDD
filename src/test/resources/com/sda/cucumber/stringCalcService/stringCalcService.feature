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