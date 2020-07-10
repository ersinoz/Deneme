package day12;

import org.openqa.selenium.JavascriptExecutor;
import utils.BaseStaticDriver;

public class _10_Romainpenchenat extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://romainpenchenat.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        for (int i = 0; i < 2000 ; i++) {
            js.executeScript("window.scrollBy(0,10)");
        }
        System.out.println("Done");
//        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
    }
}
