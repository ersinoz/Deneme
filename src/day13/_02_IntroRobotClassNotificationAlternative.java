package day13;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.HashMap;
import java.util.Map;

public class _02_IntroRobotClassNotificationAlternative {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "E:\\projects\\Selenium\\driver\\chromedriver.exe");
        Map<String, Object> prefs = new HashMap<String, Object>();
        prefs.put("profile.default_content_setting_values.notifications", 2); // 1 accept, 2 deny
        ChromeOptions options = new ChromeOptions();
        options.setExperimentalOption("prefs", prefs);
        WebDriver driver = new ChromeDriver(options);


        driver.get("https://www.cleartrip.com/");

    }
}
