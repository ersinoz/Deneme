package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class _14_SendKeys {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // this will open the chrome browser
        driver.get("http://www.practiceselenium.com");  // this will open the website and wait until full load
        driver.findElement(By.linkText("Check Out")).click();
        WebElement emailInput = driver.findElement(By.id("email"));
        emailInput.sendKeys("info@techno.study");
//        driver.quit();
    }
}
