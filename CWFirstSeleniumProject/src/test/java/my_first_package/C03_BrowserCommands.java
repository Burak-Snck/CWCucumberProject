package my_first_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C03_BrowserCommands {
    /*
     Create main method
     Set Path
     Create chrome driver
     Open google home page: https://www.google.com
     Get Title on page
     Get Current URL on page
     Close/Quit the browser
 */
    public static void main(String[] args) {

//     Set Path
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

//     Create chrome driver
        WebDriver driver = new ChromeDriver();

//     Open google home page: https://www.google.com
        driver.manage().window().maximize();
        driver.get("https://www.google.com");

//     Get Title on page
        String title = driver.getTitle();
        System.out.println("title = " + title);

//     Get Current URL on page
        String url = driver.getCurrentUrl();
        System.out.println("url = " + url);

        //Get Page Source
        String pageSource = driver.getPageSource();
        System.out.println("pageSource = " + pageSource);

//     Close/Quit the browser
        driver.quit();

    }
}
