package day12;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

public class _02_IntroScrollingUp extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://triplebyte.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll down vertically by 2000 pixels
        js.executeScript("window.scrollBy(0, 2000)");
        Thread.sleep(2000);
        js.executeScript("window.scrollBy(0, -1000)");
    }
}
