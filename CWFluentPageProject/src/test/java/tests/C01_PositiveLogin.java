package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.ContactListPage;

import java.time.Duration;

import static org.testng.Assert.assertTrue;


public class C01_PositiveLogin {

    WebDriver driver;
    ContactListPage contactListPage;

    @BeforeMethod
    public void setUp() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://thinking-tester-contact-list.herokuapp.com/");
        contactListPage = new ContactListPage(driver);//Bu clssın driverını kullanarak obje oluşturuyoruz
    }

    @AfterMethod
    public void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
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
        contactListPage.enterEmail("clarusway@hotmail.com").enterPassword("Clarusway.123")
                .clickSubmit().assertLogout();

    }

    @Test
    public void usingByObject(){

        //BeforeMthod ile anasayfaya gittikten sonra, bu method ile signUp butonunun
        // varlığını By objesini kullanarak doğruluyoruz
        assertTrue(driver.findElement(contactListPage.signup).isDisplayed());

    }


}
