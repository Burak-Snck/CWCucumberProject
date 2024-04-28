package pages;

import io.qameta.allure.Step;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.ConfigReader;
import utilities.Driver;

public class HomePage {
    public HomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }


    @FindBy(id = "search-input")
    WebElement INPUT_SEARCH_BOX;


private static final Logger LOG = LogManager.getLogger(HomePage.class);

    @Step("User go to url")
    public void go_to_url(String URL){
        Driver.getDriver().get(ConfigReader.getProperty(URL));
        LOG.info("User go to "+ConfigReader.getProperty(URL));
    }

    public void searchProduct(String productName){
        INPUT_SEARCH_BOX.sendKeys(productName+ Keys.ENTER);
        LOG.info("User search this product" + productName);
    }


    public void verifyTitle(String expectedTitle){
        Assert.assertTrue(Driver.getDriver().getTitle().equals(expectedTitle));
        LOG.info("User verify title " + Driver.getDriver().getTitle());
    }

}
