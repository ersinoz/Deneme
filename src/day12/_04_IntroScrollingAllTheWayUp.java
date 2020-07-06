package day12;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseDriver;

public class _04_IntroScrollingAllTheWayUp extends BaseDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://triplebyte.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll all the way down
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        Thread.sleep(2000);
        // scroll all the way up
        js.executeScript("window.scrollTo(0, -document.body.scrollHeight)");
    }
}
