package my_first_package;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_NavigationCommands {
    /*
            Chrome tarayıcısını başlat ve pencereyi tam ekran yap
            https://clarusway.com/ adresine git
            http://google.com/ adresine git
            Geri komutu kullanarak Clarusway'e geri dön
            İleri komutu kullanarak tekrar Google websitesine git
            Sayfayı yenile
            Tarayıcıyı kapat
    */
    public static void main(String[] args) throws InterruptedException {

//    Chrome tarayıcısını başlat ve pencereyi tam ekran yap
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

//    https://clarusway.com/ adresine git
        driver.get("https://clarusway.com/ ");

//    http://google.com/ adresine git
        driver.navigate().to("http://google.com/");

//    back() komutu kullanarak Clarusway'e geri dön
        Thread.sleep(3000);// 2000 millisecond Java'nın çalışmasını durdurur
        driver.navigate().back();

//    forward() komutu kullanarak tekrar Google websitesine git
        Thread.sleep(3000);
        driver.navigate().forward();

//    Sayfayı yenile
        Thread.sleep(3000);
        driver.navigate().refresh();

//    Tarayıcıyı kapat
        Thread.sleep(3000);
        driver.quit();

    }

}
