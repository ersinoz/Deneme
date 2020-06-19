package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _12_NavigatingBack {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // this will open the chrome browser
        driver.navigate().to("http://www.practiceselenium.com");  // this will open the website and wait until full load
        driver.findElement(By.linkText("Check Out")).click();
        Thread.sleep(3000);
        driver.navigate().back();
//        driver.quit();
    }
}
