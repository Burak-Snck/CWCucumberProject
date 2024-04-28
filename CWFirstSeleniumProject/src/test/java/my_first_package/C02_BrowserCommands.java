package my_first_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class C02_BrowserCommands {

    public static void main(String[] args) {

        //WebDriver'ı başlatmak için gerekli Chrome driverını belirtelim
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");

        //WebDriver objesi oluştuşturalım
        WebDriver driver = new ChromeDriver();

        //Sayfayı tam ekran yapalım
        driver.manage().window().maximize();
        //driver.manage().window().minimize();
        //driver.manage().window().fullscreen();

        // Clarusway sayfasına gidelim
        driver.get("https://clarusway.com");

        // Google sayfasına gidelim
        String googleUrl = "https://google.com";

        driver.get(googleUrl);

        //Tarayıcıyı kapat
        driver.quit();

    }

}
