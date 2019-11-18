Feature: Is it Friday yet?
  Everybody wants to know when it's Friday

  Scenario Outline: Today is or is not Friday
    Given today is "<day>"
    When I ask if it's Friday yet
    Then The answer should be "<answer>"

  Examples:
    | day            | answer |
    | Monday         | Nope   |
    | Tuesday        | Nope   |
    | Wednesday      | Nope   |
    | Thursday       | Nope   |
    | Friday         | Yep    |
    | Saturday       | Nope   |
    | Sunday         | Nope   |