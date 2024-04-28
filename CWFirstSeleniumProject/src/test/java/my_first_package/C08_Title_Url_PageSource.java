package my_first_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08_Title_Url_PageSource {
    /*
        Go to Clarusway homaepage
        Verify title contains 'Bootcamp'
        Verify URL contains 'clarusway'
        Verify PageSource contains 'SDET'
     */
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//    Go to Clarusway homaepage
        driver.get("https://clarusway.com");

//    Verify title contains 'Bootcamp'
        if (driver.getTitle().contains("Bootcamp")) {
            System.out.println("Title Test PASSED");
        } else {
            System.out.println("Title Test FAILED");
        }

//    Verify URL contains 'clarusway'
        if (driver.getCurrentUrl().contains("clarusway")) {
            System.out.println("URL Test PASSED");
        } else {
            System.out.println("URL Test FAILED");
        }


//    Verify PageSource contains 'SDET'
        if (driver.getPageSource().contains("SDET")) {
            System.out.println("PageSource Test PASSED");
        } else {
            System.out.println("PageSource Test FAILED");
        }

        driver.quit();

    }

}
