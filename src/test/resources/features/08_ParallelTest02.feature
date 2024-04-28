@Parallel
Feature:
  Scenario: linkedin Test
 Given  user goes to url "https://www.youtube.com/"
    When user verifies title contains "linkedIn"
    Then user closes driver