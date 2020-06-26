package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseDriver {
    public static WebDriver driver;
    static {
        System.setProperty("webdriver.chrome.driver", "D:\\cmd_soft\\selenium\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
    }
}
