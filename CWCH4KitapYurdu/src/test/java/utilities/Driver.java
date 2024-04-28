package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {
    private static WebDriver driver;

    private Driver(){

    }



    public static WebDriver getDriver(){

        String browser = ConfigReader.getProperty("browser");
        if(driver == null){

            switch (browser){

                case "firefox":

                    driver = new FirefoxDriver();
                    break;

                case "edge":

                    driver = new EdgeDriver();
                    break;

                default:

                    driver = new ChromeDriver();
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        }

        return driver;
    }


    public static void closeDriver(){
        if(driver != null){
            driver.quit();
            driver = null;
        }
    }
}
