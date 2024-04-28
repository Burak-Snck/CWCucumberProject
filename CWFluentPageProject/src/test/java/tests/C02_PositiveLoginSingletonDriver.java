package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactListPage;
import pages.ContactListSingletonDriverPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.time.Duration;

import static org.testng.Assert.assertTrue;


public class C02_PositiveLoginSingletonDriver {


    ContactListSingletonDriverPage contactListPage;

    @BeforeMethod
    public void setUp() {

        Driver.getDriver().get(ConfigReader.getProperty("contact_list_url"));
        contactListPage = new ContactListSingletonDriverPage();//Bu classın driverını kullanarak obje oluşturuyoruz
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        Driver.closeDriver();
    }


    @Test
    public void positiveLoginTest(){

        contactListPage.enterEmail("clarusway@hotmail.com");
        contactListPage.enterPassword("Clarusway.123");
        contactListPage.clickSubmit();
        contactListPage.assertLogout();

    }


    @Test
    public void testMethodChain(){

        //Her method ContactListPage class'ının objesini döneceğinden, method chain şeklinde kullanılabilir
        contactListPage.enterEmail("clarusway@hotmail.com").enterPassword("Clarusway.123").clickSubmit().assertLogout();

    }

    @Test
    public void usingByObject(){

        //BeforeMthod ile anasayfaya gittikten sonra, bu method ile signUp butonunun varlığını By objesini kullanarak doğruluyoruz
        assertTrue(Driver.getDriver().findElement(contactListPage.signup).isDisplayed());

    }


}
