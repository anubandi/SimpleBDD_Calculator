Feature: Calculator

  Scenario Outline: Add two numbers
    Given I have the numbers <a> and <b>
    When I add them
    Then the result is <sum>

    @smoke
    Examples:

      | a | b | sum |
      | 2 | 3 | 5   |
      | 3 | 4 | 7   |


    @negative
    Examples:

      | a  | b  | sum |
      | -5 | -3 | -8  |
      | -2 | -4 | -6   |