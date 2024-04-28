package my_first_package;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_Window_Commands {
/*
    Invoke Chrome Browser
    Open URL: https://www.google.com/
    Maximize the window.
    Print the position and size of the page.
    Minimize the page.
    Wait 5 seconds in the icon state and maximize the page.
    Print the position and dimensions of the page in maximized state.
    Make the page fullscreen.
    Close the Browser.
 */

    public static void main(String[] args) throws InterruptedException {
//        Invoke Chrome Browser
        System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();

//        Open URL: https://www.google.com/
        driver.get("https://www.google.com/");

//        Maximize the window.
        driver.manage().window().maximize();

//        Print the position and size of the page.
        Point position = driver.manage().window().getPosition();
        Dimension size = driver.manage().window().getSize();

        System.out.println("position = " + position);
        System.out.println("size = " + size);

//        Minimize the page.
        driver.manage().window().minimize();

//        Wait 5 seconds in the icon state and maximize the page.
        Thread.sleep(5000);
        driver.manage().window().maximize();

//        Print the position and dimensions of the page in maximized state.
        Point position2 = driver.manage().window().getPosition();
        Dimension size2 = driver.manage().window().getSize();

        System.out.println("position2 = " + position2);
        System.out.println("size2 = " + size2);

//        Make the page fullscreen.
        driver.manage().window().fullscreen();

//        Close the Browser.
        Thread.sleep(3000);
        driver.quit();

    }

}
