Feature: Parameterizing Feature

  Background: User goes to homepage
    Given user goes to homepage

  @FailedScenario @Smoke
  Scenario: Positive Login
    When user enters username "XYZ@hotmail.com"
    And user enters password "Clarusway.123"
    And user clicks on submit button
    Then user validates sign in
    And user closes browser

