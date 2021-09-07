Feature: Does the Calculator calculate correctly?

  Scenario Outline: Calculation
    Given launched Calculator
    When I'm doing <operation> on <number1> and <number2>
    Then I should receive <result>
    Examples:
      | operation        | number1 | number2 | result |
      | "Multiplication" | 4       | 6       | 24     |
      | "Division"       | 9       | 2       | 4.5    |
      | "Plus"           | 9       | 7       | 16     |
      | "Minus"          | 7       | 3       | 5      |
