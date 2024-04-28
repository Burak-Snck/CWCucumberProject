package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import utilities.Driver;

import java.util.List;
import java.util.Random;

public class SearchResultsPage {
    public SearchResultsPage(){
        PageFactory.initElements(Driver.getDriver(),this);

    }
    private static final Logger LOG = LogManager.getLogger(SearchResultsPage.class);


    @FindBy(xpath = "(//h1[@class='search-heading-title']//span)[2]")
    WebElement TXT_RESULTTITLE;

    @FindBy(xpath = "//div[@class='product-cr']//div[@class='name']//a")
    List<WebElement> searchBookLists;

    public void verifySearchResult(String product){
        assertText(TXT_RESULTTITLE.getText(),product);
    }


    public void chooseRandomBook(int index) throws InterruptedException {


            searchBookLists.get(index).click();

    }

    public void assertText(String expexted,String actual){
        Assert.assertTrue(expexted.equals(actual));
    }

    public void clickElement(WebElement element){
        element.click();
    }


}
