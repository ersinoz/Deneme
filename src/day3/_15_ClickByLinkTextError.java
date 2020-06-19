package day3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class _15_ClickByLinkTextError {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\Driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver(); // this will open the chrome browser
        driver.get("http://www.practiceselenium.com");  // this will open the website and wait until full load
        driver.findElement(By.linkText("Check Out")).click();
        driver.findElement(By.id("email")).sendKeys("info@techno.study");
        driver.findElement(By.id("name")).sendKeys("Fatih");
        driver.findElement(By.id("address")).sendKeys("Getty Ave 600");
//        driver.findElement(By.className("btn-primary")).click(); // cannot use space in class name
        driver.findElement(By.linkText("Place Order")).click(); // link text only works on anchor tags
        // since out button is not an anchor tag, but a button, this will not work
//        driver.quit();
    }
}
