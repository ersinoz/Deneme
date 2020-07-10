package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseDriver {
    protected WebDriver driver;
    protected Actions builder;

    @BeforeClass
    protected void setup(){
        System.setProperty("webdriver.chrome.driver", "E:\\projects\\Selenium\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        builder = new Actions(driver);
    }

    @AfterClass
    protected void closeDriver() {
//        driver.quit();
    }
}
