
@Login
Feature: Login Test

  #Her Scenario öncesi çalışır
  Background: User goes to homepage
    Given user goes to homepage


  @PositiveLogin @Positive
  Scenario: Positive Login
    #Not satırı
    When user enters valid username
    And user enters valid password
    And user clicks on submit button
    Then user validates sign in
    And user closes browser

  @NegativeLogin
  Scenario: Negative Login
    When user enters wrong username
    And user enters valid password
    And user clicks on submit button
    Then user validates error message
    And user closes browser

  @EmptyCredentials
  Scenario: Negative Login With Empty Credentials
    When user clicks on submit button
    Then user validates error message
    And user closes browser