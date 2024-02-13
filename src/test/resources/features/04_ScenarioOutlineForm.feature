@FormPage
Feature: Form Test Scenario Outline

  Scenario Outline: Form Test

    Given go to form page
    When enter username "<username>"
    And enter password "<password>"
    And enter comment "<comment>"
    And click on submit
    Then user closes browser
    Examples:
      | username | password | comment |
