package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import utilities.Driver;

public class CommonStepDefinitions {

    @And("user closes browser")
    public void userClosesBrowser() {

        Driver.closeDriver();

    }

    @Given("go to {string}")
    public void go_to(String url) {

        Driver.getDriver().get(url);

    }
}