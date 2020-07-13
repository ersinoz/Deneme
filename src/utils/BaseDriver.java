package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseDriver {
    protected WebDriver driver;
    protected Actions builder;
    protected WebDriverWait wait;

    @BeforeClass
    protected void setup(){
        System.setProperty("webdriver.chrome.driver", "E:\\projects\\Selenium\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        builder = new Actions(driver);
        wait = new WebDriverWait(driver, 10);
    }

    @AfterClass
    protected void closeDriver() {
//        driver.quit();
    }
}
