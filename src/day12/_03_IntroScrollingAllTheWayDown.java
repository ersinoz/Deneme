package day12;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

public class _03_IntroScrollingAllTheWayDown extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://triplebyte.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        // scroll all the way down
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
