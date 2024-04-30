@Todo
Feature: Data Tables

  @Smoke
  Scenario: Todo List Data Table
    Given go to "https://webdriveruniversity.com/To-Do-List/index.html"
    When enter todos
      | Prepare breakfast        |
      | Wash the dishes          |
      | Take care of baby        |
      | Help your kid's homework |
      | Study Selenium           |
      | Sleep                    |

    Then user closes browser


  @MapDataTable
  Scenario:  Form Page Data Table Map

    Given go to form page
    When user enters username and password
      | john_doe | John.123 |
      | ali_can  | Ali.123  |
      | ayse_han | Ayse.123 |
    Then  click on submit
    Then user closes browser


  @ListOfListDataTable
  Scenario: Form Page Data Table List<List<>>
    Given go to form page
    When user enter s username, password and comment
      | john_doe | John.123 | Hello I am John |
      | ali_can  | Ali.123  | Hello I am Ali  |
      | ayse_han | Ayse.123 | Hello I am Ayse |
    Then user closes browser



