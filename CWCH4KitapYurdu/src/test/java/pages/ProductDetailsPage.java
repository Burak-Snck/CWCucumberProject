package pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utilities.Driver;

import java.time.Duration;

public class ProductDetailsPage {

    public ProductDetailsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    private static final Logger LOG = LogManager.getLogger(SearchResultsPage.class);

@FindBy(id = "button-cart")
WebElement BTN_SEPETEEKLEBUTTON;
@FindBy(xpath = "//span[@id='cart-items']")
WebElement TXT_SEPET_COUNT;
@FindBy(id = "cookiescript_accept")
WebElement cookiesAccept;
@FindBy(id = "js-cart")
WebElement BTN_PRODUCTDETAILSPAGE_SEPETEGIT;

    public void clickSepeteEkleButton(){
clickElement(BTN_SEPETEEKLEBUTTON);
    }
public void verifySepetCount(String count) throws InterruptedException {
Thread.sleep(3000);
clickElement(cookiesAccept);
    Assert.assertTrue(TXT_SEPET_COUNT.getText().equals(count));
}
public void go_to_sepet(){
clickElement(TXT_SEPET_COUNT);
clickElement(BTN_PRODUCTDETAILSPAGE_SEPETEGIT);
}

    public void clickElement(WebElement element){
        element.click();
    }

}
