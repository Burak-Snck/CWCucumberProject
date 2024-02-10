package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.ContactListContactPage;
import pages.ContactListHomePage;
import utilities.ConfigReader;
import utilities.Driver;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ContactListStepDefinitions {

    ContactListHomePage contactListHomePage = new ContactListHomePage();
    ContactListContactPage contactListContactPage = new ContactListContactPage();

    @Given("user goes to homepage")
    public void user_goes_to_homepage() {

        Driver.getDriver().get(ConfigReader.getProperty("contact_list_url"));

    }
    @When("user enters valid username")
    public void user_enters_valid_username() {

        contactListHomePage.username.sendKeys(ConfigReader.getProperty("contact_list_username"));

    }
    @When("user enters valid password")
    public void user_enters_valid_password() {

        contactListHomePage.password.sendKeys(ConfigReader.getProperty("contact_list_password"));

    }
    @When("user clicks on submit button")
    public void user_clicks_on_submit_button() {

        contactListHomePage.submit.click();

    }
    @Then("user validates sign in")
    public void user_validates_sign_in() {

        assertTrue(contactListContactPage.logout.isDisplayed());

    }

    @And("user closes browser")
    public void userClosesBrowser() {

        Driver.closeDriver();

    }
    @When("user enters wrong username")
    public void user_enters_wrong_username() {

        contactListHomePage.username.sendKeys("wrong@wrong.com");

    }
    @Then("user validates error message")
    public void user_validates_error_message() throws InterruptedException {

        Thread.sleep(500);
        String errorMessage = contactListHomePage.error.getText();

        assertEquals("Incorrect username or password", errorMessage);

    }


    @When("user enters username {string}")
    public void userEntersUsername(String username) {

        contactListHomePage.username.sendKeys(username);

    }

    @And("user enters password {string}")
    public void userEntersPassword(String password) {

        contactListHomePage.password.sendKeys(password);

    }

    @When("user enters username {string} and password {string}")
    public void userEntersUsernameAndPassword(String username, String password) {
        contactListHomePage.username.sendKeys(username);
        contactListHomePage.password.sendKeys(password);
    }
}
