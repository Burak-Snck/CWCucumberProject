package stepdefinitions;


import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import utilities.Driver;

public class Hooks {
    //Her scenario yada özel tag öncesi yada sonrası çalışan methodların bulunduğu class
    //@Before("@Positive") yanına girilen özel tag ile yalnızca bu scenariolar için çalıştırılabilir.
    //@Before şeklinde tek kullanıldığında tüm scenariolar öncesi çalışır.

    @Before//("@Positive")// --> import io.cucumber.java.Before; !!!!!!!!!!
    public void setUp(Scenario scenario){
        System.out.println("Hooks Class @Before Methodu");
        System.out.println("Scenario ID: "+scenario.getId());
        System.out.println("Scenario Name: "+scenario.getName());
    }

    @After//import io.cucumber.java.After;
    public void tearDown(Scenario scenario){
        //System.out.println("Hooks Class @After Methodu");
        if (scenario.isFailed()){//Eğer scenario fail olursa

            System.out.println("Senaryo başarısız oldu");
            final byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", "Başarısız Senaryo Ekran Görüntüsü");
            System.out.println("Başarısız senaryo için ekran görüntüsü alındı: " + scenario.getName());
            // Tarayıcıda rapor açıldığında ekli olan resme tıklayarak ekran görüntüsünü görebilirsiniz.

        }

        try {Thread.sleep(3000);} catch (InterruptedException ignored) {}

        Driver.closeDriver();
    }
}