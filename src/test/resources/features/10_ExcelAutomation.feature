@Excel
Feature: Excel Automation

  Scenario: Datatable Test
    Given go to "https://editor.datatables.net/"
    When user enters credentials from excel "employees", sheet "info"
    Then user closes browser


