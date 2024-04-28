package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;

import static utilities.ConfigReader.getProperty;

public class ParallelDriver {
    // Her bir thread için ayrı bir WebDriver örneğini yönetmek için ThreadLocal kullanılır.
    private static final ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public ParallelDriver() {
    }

    public static WebDriver getDriver() {
        // Eğer sürücü havuzunda bir sürücü yoksa
        if (driverPool.get() == null) {
            // Ortam değişkenlerinden tarayıcı parametresini al
            String browserParamFromEnv = System.getProperty("browser");
            // Eğer ortam değişkeni yoksa varsayılan değeri al
            String browser = (browserParamFromEnv == null) ? getProperty("browser") : browserParamFromEnv;

            WebDriver driver = null;

            // Tarayıcı türüne göre işlem yap
            switch (browser) {
                case "chrome":
                    // Chrome için sürücüyü ayarla ve oluştur
                    driver = new ChromeDriver();
                    break;
                case "chrome_headless":
                    // Başsız (Headless) Chrome için sürücüyü ayarla ve oluştur
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));
                    break;
                case "firefox":
                    // Firefox için sürücüyü ayarla ve oluştur

                    driver = new FirefoxDriver();
                    break;
                case "ie":
                    // Internet Explorer için sürücüyü ayarla ve oluştur
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Internet Explorer");
                    }
                    driver = new InternetExplorerDriver();
                    break;
                case "edge":
                    // Edge için sürücüyü ayarla ve oluştur
                    if (!System.getProperty("os.name").toLowerCase().contains("windows")) {
                        throw new WebDriverException("Your OS doesn't support Edge");
                    }
                    driver = new EdgeDriver();
                    break;
                case "safari":
                    // Safari için sürücüyü ayarla ve oluştur
                    if (!System.getProperty("os.name").toLowerCase().contains("mac")) {
                        throw new WebDriverException("Your OS doesn't support Safari");
                    }
                    driver = new SafariDriver();
                    break;
                default:
                    // Varsayılan olarak Chrome sürücüsünü ayarla ve oluştur
                    driver = new ChromeDriver();
                    break;
            }

            // Oluşturulan sürücü varsa pencereyi maksimize et ve bekleme süresini ayarla
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
            driverPool.set(driver); // Sürücüyü havuza ekle
        }

        return driverPool.get(); // Oluşturulan veya mevcut sürücüyü döndür
    }


    // Mevcut WebDriver örneğini kapatır ve temizler.
    public static void closeDriver() {
        WebDriver driver = driverPool.get();
        if (driver != null) {
            driver.quit();
            driverPool.remove();
        }
    }
}