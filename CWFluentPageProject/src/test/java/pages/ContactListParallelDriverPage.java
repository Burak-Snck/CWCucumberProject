package pages;

import org.openqa.selenium.By;
import utilities.Driver;
import utilities.ParallelDriver;

import static org.testng.AssertJUnit.assertTrue;

public class ContactListParallelDriverPage {

    public By email = By.id("email");
    public By password = By.id("password");
    public By submit = By.id("submit");
    public By logout = By.id("logout");
    public By addContact = By.id("add-contact");
    public By signup = By.id("signup");

    public ContactListParallelDriverPage enterEmail(String email) {
        ParallelDriver.getDriver().findElement(this.email).sendKeys(email);
        return this;//Her method bu class'ın objesini döneceğinden, method chain şeklinde kullanılabilir
    }

    public ContactListParallelDriverPage enterPassword(String password) {
        ParallelDriver.getDriver().findElement(this.password).sendKeys(password);
        return this;
    }

    public ContactListParallelDriverPage clickSubmit() {
        ParallelDriver.getDriver().findElement(this.submit).click();
        return this;
    }

    public ContactListParallelDriverPage assertLogout() {
        assertTrue(ParallelDriver.getDriver().findElement(logout).isDisplayed());
        return this;
    }

}
