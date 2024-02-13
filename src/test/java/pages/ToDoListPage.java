package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class ToDoListPage {

    public ToDoListPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(tagName = "input")
    public WebElement input;



}
