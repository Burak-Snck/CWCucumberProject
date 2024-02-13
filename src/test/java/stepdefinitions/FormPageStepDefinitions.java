package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.it.Ma;
import pages.FormHomePage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;
import java.util.Map;

public class FormPageStepDefinitions {

    FormHomePage formHomePage = new FormHomePage();

    @Given("go to form page")
    public void go_to_form_page() {

        Driver.getDriver().get(ConfigReader.getProperty("form_page_url"));

    }

    @When("enter username {string}")
    public void enter_username(String username) {

        formHomePage.username.sendKeys(username);

    }

    @When("enter password {string}")
    public void enter_password(String password) {

        formHomePage.password.sendKeys(password);

    }

    @When("enter comment {string}")
    public void enter_comment(String comment) {

        formHomePage.comments.clear();
        formHomePage.comments.sendKeys(comment);

    }

    @And("click on submit")
    public void clickOnSubmit() {

        formHomePage.submit.click();

    }

    @When("user enters username and password")
    public void user_enters_username_and_password(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        //DataTable'da 2 sütun var ise Map<String, String> şeklinde alınabilir
        Map<String, String> usernamePassword = dataTable.asMap();
        System.out.println("usernamePassword = " + usernamePassword);

        //Map, entrySet kullanılarak loop içinde kullanılabilir
        for (Map.Entry<String, String> w : usernamePassword.entrySet()) {

            String username = w.getKey();
            String password = w.getValue();

            System.out.println("username = " + username);
            System.out.println("password = " + password);

            formHomePage.username.sendKeys(username);
            formHomePage.password.sendKeys(password);

            Thread.sleep(2000);

            Driver.getDriver().navigate().refresh();


        }

    }

    @When("user enters username, password and comment")
    public void user_enters_username_password_and_comment(io.cucumber.datatable.DataTable dataTable) throws InterruptedException {

        //2'den fazla sütunu bulunana data table için List<List<>> yapısı daha uygundur.
        List<List<String>> rows = dataTable.asLists();
        System.out.println("rows = " + rows);

//        List<String> ayseRow = rows.get(2);
//        System.out.println("ayseRow = " + ayseRow);

        for (List<String> w : rows) {

            String username = w.get(0);
            String password = w.get(1);
            String comment = w.get(2);

            formHomePage.username.sendKeys(username);
            formHomePage.password.sendKeys(password);
            formHomePage.comments.sendKeys(comment);

            Thread.sleep(1000);
            Driver.getDriver().navigate().refresh();

        }

    }

}
