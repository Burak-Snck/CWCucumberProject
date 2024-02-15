package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.ConfigReader;
import utilities.Driver;

public class ContactListHomePage {

    public ContactListHomePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "email")
    public WebElement username;

    @FindBy(id = "password")
    public WebElement password;

    @FindBy(id = "submit")
    public WebElement submit;

    @FindBy(id = "error")
    public WebElement error;





}