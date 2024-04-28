package my_first_package;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_GetPosition_SetPosition {
    /*
         Go to the Clarusway URL : https://www.clarusway.com/
         Print the position and size of the page.
         Adjust the position and size of the page as desired.
         Test that the page is in the position and size you want.
         Close the page.
     */
    public static void main(String[] args) throws InterruptedException {

//     Go to the Clarusway URL : https://www.clarusway.com/
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.clarusway.com/");

//     Print the position and size of the page.
        System.out.println("Postion: " + driver.manage().window().getPosition());
        System.out.println("Size: " + driver.manage().window().getSize());

//     Adjust the position and size of the page as desired.
        Point targetPosition = new Point(20, 25);
        Dimension targetSize = new Dimension(600, 300);
        driver.manage().window().setPosition(targetPosition);
        driver.manage().window().setSize(targetSize);

//     Test that the page is in the position and size you want.
        int x = driver.manage().window().getPosition().getX();
        int y = driver.manage().window().getPosition().getY();

        int height = driver.manage().window().getSize().getHeight();
        int width = driver.manage().window().getSize().getWidth();

        System.out.println(driver.manage().window().getPosition());
        System.out.println(driver.manage().window().getSize());

        if (x == 20 && y == 25 && height == 300 && width == 600) {
            System.out.println("TEST PASSED");
        } else {
            System.out.println("TEST FAILED");
        }

//     Close the page.
        Thread.sleep(3000);
        driver.quit();

    }
}
