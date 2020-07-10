package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseStaticDriver {
    public static WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", "E:\\projects\\Selenium\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
}
