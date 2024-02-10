@Parameterizing
Feature: Parameterizing Feature

  Background: User goes to homepage
    Given user goes to homepage

  @PositiveLoginParam
  Scenario: Positive Login
    When user enters username "clarusway@hotmail.com"
    And user enters password "Clarusway.123"
    And user clicks on submit button
    Then user validates sign in
    And user closes browser

  @PositiveLoginParam2 @Positive
  Scenario: Positive Login 2
    When user enters username "john.doe@gmail.com"
    And user enters password "John.123"
    And user clicks on submit button
    Then user validates sign in
    And user closes browser


  @NegativeLoginParam
  Scenario: Negative Login
    When user enters username "wrongemail@gmail.com"
    And user enters password "Clarusway.123"
    And user clicks on submit button
    Then user validates error message
    And user closes browser

  @WrongPassword
  Scenario: Wrong Email
    When user enters username "clarusway@hotmail.com"
    And user enters password "XYZ.123"
    And user clicks on submit button
    Then user validates error message
    And user closes browser

  @WrongCredentials
  Scenario: Wrong Credentials
    When user enters username "XYZ@hotmail.com"
    And user enters password "XYZ.123"
    And user clicks on submit button
    Then user validates error message
    And user closes browser


  @MultiParameters
  Scenario: Positive Login MultiParameters
    When user enters username "clarusway@hotmail.com" and password "Clarusway.123"
    And user clicks on submit button
    Then user validates sign in
    And user closes browser

  @MultiParametersNegative
  Scenario: Negative Login MultiParameters
    When user enters username "wrong@hotmail.com" and password "Clarusway.123"
    And user clicks on submit button
    Then user validates error message
    And user closes browser

  Scenario: Empty Login MultiParameters
    When user enters username "" and password ""
    And user clicks on submit button
    Then user validates error message
    And user closes browser
