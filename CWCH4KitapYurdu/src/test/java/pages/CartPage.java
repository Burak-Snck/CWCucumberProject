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

public class CartPage {
    public CartPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    private static final Logger LOG = LogManager.getLogger(CartPage.class);

    @FindBy(xpath = "//input[@name='quantity']")
    WebElement sepet_quantity;

    @FindBy(xpath = "//i[@class='fa fa-refresh green-icon']")
    WebElement refreshButton;

    @FindBy(xpath = "//h2[@id='swal2-title']")
    WebElement refrestPopup;

    @FindBy(xpath = "//i[@title='Kaldır']")
    WebElement removeCart;

    @FindBy(id = "cart-items-empty")
    WebElement sepeteControl;


    public void changeSepeteQuantity(){

       String quantity= getAttribute(sepet_quantity,"value");

       int q=Integer.parseInt(quantity);

       int sum=q+1;

       String result=String.valueOf(sum);

        sepet_quantity.clear();
        sepet_quantity.sendKeys(result);
LOG.info("User changed sepet quantity");

    }

    public void clickRefreshButton(){
        clickElement(refreshButton);
        LOG.info("User click refresh bıtton");
}

public void verifySepetinizGuncelleniyor(){
    Assert.assertTrue(refrestPopup.isDisplayed());
    LOG.info("User verify cart update");
}
public void removeCart(){
        clickElement(removeCart);
}
public void assertCart(){
    WebDriverWait w = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(10));
    w.until(ExpectedConditions.visibilityOf(sepeteControl));
        Assert.assertTrue(sepeteControl.isDisplayed());
}










    public void clickElement(WebElement element){
        element.click();
    }













    public String getAttribute(WebElement element, String att){

       return element.getAttribute(att);
    }


}
