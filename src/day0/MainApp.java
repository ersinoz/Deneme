package day0;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MainApp {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get( "https://google.com" );

    }
}
