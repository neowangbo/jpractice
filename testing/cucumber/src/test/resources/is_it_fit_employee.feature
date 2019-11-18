Feature: What kind of employee he is?
  Everybody wants to know if it is a fit employee, and if it can become a leader

  Scenario: fit employee but not a leader
    Given gender is male
    And age is within 30 and 40
    And it is not married yet
    When I ask whether it is a fit employee
    When I ask whether it can become a leader
    Then it is a fit employee
    But it should not be a leader