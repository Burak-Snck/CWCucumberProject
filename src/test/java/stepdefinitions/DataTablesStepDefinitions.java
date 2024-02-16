package stepdefinitions;

import io.cucumber.java.en.When;
import pages.DataTablesPage;
import utilities.ExcelUtils;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DataTablesStepDefinitions {

    DataTablesPage dataTablesPage = new DataTablesPage();

    @When("user enters credentials from excel {string}, sheet {string}")
    public void user_enters_credentials_from_excel_sheet(String excelFile, String sheetName) {

        ExcelUtils excelUtils = new ExcelUtils("src/test/resources/" + excelFile + ".xlsx", sheetName);

        List<Map<String, String>> dataList = excelUtils.getDataList();

        int counter = 1;
        for (Map<String, String> w : dataList) {

            System.out.println("Row " + counter + ": " + w);
            counter++;

            String first_name = w.get("first_name");
            String last_name = w.get("last_name");
            String office = w.get("office");
            String extension = w.get("extension");
            String position = w.get("position");
            String salary = w.get("salary");
            String start_date = w.get("start_date");

            dataTablesPage.newButton.click();
            dataTablesPage.first_name.sendKeys(first_name);
            dataTablesPage.last_name.sendKeys(last_name);
            dataTablesPage.office.sendKeys(office);
            dataTablesPage.extension.sendKeys(extension);
            dataTablesPage.position.sendKeys(position);
            dataTablesPage.salary.sendKeys(salary);
            dataTablesPage.start_date.sendKeys(start_date);
            dataTablesPage.createButton.click();
            dataTablesPage.search.clear();
            dataTablesPage.search.sendKeys(first_name);

            assertTrue(dataTablesPage.nameCell.getText().contains(first_name));

        }

    }

}
