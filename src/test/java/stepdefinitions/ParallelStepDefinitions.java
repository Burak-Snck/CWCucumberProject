package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.FormHomeParallelPage;
import utilities.ConfigReader;
import utilities.ParallelDriver;


import static org.junit.Assert.assertTrue;

public class ParallelStepDefinitions {

    FormHomeParallelPage formHomePage = new FormHomeParallelPage();

    @Given("user goes to home page")
    public void user_goes_to_home_page() {

        ParallelDriver.getDriver().get(ConfigReader.getProperty("form_page_url"));

    }

    @When("user enters username")
    public void user_enters_username() {

        formHomePage.username.sendKeys("Ali");

    }

    @When("user enters password")
    public void user_enters_password() {

        formHomePage.password.sendKeys("123");


    }

    @And("user enters comment")
    public void userEntersComment() {

        formHomePage.comments.clear();
        formHomePage.comments.sendKeys("Hello, My name is Ali");

    }

    @Then("user closes driver")
    public void user_closes_driver() throws InterruptedException {

        Thread.sleep(2000);
        ParallelDriver.closeDriver();

    }


    @When("user verifies title contains {string}")
    public void userVerifiesTitleContains(String title) {

        assertTrue(ParallelDriver.getDriver().getTitle().contains(title));

    }

    @Given("user goes to url {string}")
    public void userGoesToUrl(String url) {

        ParallelDriver.getDriver().get(url);

    }
}
