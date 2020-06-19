package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _17_MaximizeWindow {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // this will open the chrome browser
        driver.get("http://www.practiceselenium.com");  // this will open the website and wait until full load
        driver.manage().window().maximize();
//      driver.quit();
    }
}
