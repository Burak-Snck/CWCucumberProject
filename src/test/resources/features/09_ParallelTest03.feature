@Parallel
Feature:
  Scenario: google test
 Given  user goes to url " https://google.com"
    When user verifies title contains "Google"
    Then user closes driver