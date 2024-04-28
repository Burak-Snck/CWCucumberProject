package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.time.Duration;

public class Driver {

    private static WebDriver driver;

    private Driver() {
    }//new keyword'ü ile başka class'lardan bu class'ın bir objesinin oluşturulmasının önüne geçer.

    public static WebDriver getDriver() {

        if (driver == null) {//Eğer driver null(oluşturulmamış)  ise yeni driver oluştur.

            String browser = ConfigReader.getProperty("browser");//configuration.properties dosyasında yazılı browser değerini  String olarak döner

            switch (browser) {//configuration.properties dosyasından gelen değere göre ilgili browser'ı açar.

                case "chrome":
                    driver = new ChromeDriver();
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "headless":
                    driver = new ChromeDriver(new ChromeOptions().addArguments("--headless=new"));
                    break;
                default:
                    driver = new ChromeDriver();

            }

        }

        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        return driver;
    }


    public static void closeDriver() {

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        if (driver != null) {//Eğer driver null değil(oluşturulmuş) ise quit() metodunu kullan.
            driver.quit();
            driver = null;//quit() işlemi sonrası getDriver() methodunun tekrar çalışabilmsi için gerekli.
        }

    }

}

/*
Kullanılan Driver Class, tüm sınıflarda paylaşılan tek bir statik driver döndürür.
Driver Class, Framework’deki tüm class’larda aynı driver objesini kullanmamıza izin verecektir.
Singleton Driver class başlatıldığında, bu Driver class tekrar tekrar aynı driver örneğini return eder.

Singleton Pattern: Tekli kullanım, yalnızca örneği olabilecek şekilde geliştirilir, Singleton Driver kullanıcıyı WebDriver'ın
gerekli olduğu tüm örnekler için aynı objeyi kullanmaya zorlayacaktır işte tam da bu yüzden Singleton Pattern bir
classın farklı class’larda obje oluşturularak kullanımını engellemek için kullanılır.
Amaç burada; Driver class’ındaki getDriver() method’unun obje oluşturularak kullanılmasını engellemektir.

Singleton sınıfı oluşturmak için aşağıdaki adımları uygulamamız gerekiyor:
Class’ta oluşturulan constructor private olmalı böylece farklı classlarda obje oluşturulamaz.
Class’da statik bir referans variable olmalı; her yerden kullanılabilir hale getirmek için static gereklidir.
Class’ın bir kez başlatılıp başlatılmadığını kontrol etmesi gereken, class’ın objesi olarak return type static bir method
declare edilmelidir.
 */
