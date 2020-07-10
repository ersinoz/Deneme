package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Random;

public class _11_YoutubeScrollToNthElement extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.youtube.com/results?search_query=selenium");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 5);

        List<WebElement> elements = driver.findElements(By.tagName("ytd-video-renderer"));
        System.out.println("results size: " + elements.size());
        int nthElement = new Random().nextInt(elements.size());
        System.out.println("nthElement: " + nthElement);
        // scroll into view the last element
        js.executeScript("arguments[0].scrollIntoView();", elements.get(nthElement));

        System.out.println("Finished!");

    }
}
