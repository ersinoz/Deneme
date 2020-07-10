package day12;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

import java.util.List;

public class _08_YoutubePractice2 extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.youtube.com/results?search_query=selenium");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 5);

        while (true) {
            try {
                List<WebElement> elements = driver.findElements(By.tagName("ytd-video-renderer"));
                System.out.println("results size: " + elements.size());
                // scroll into view the last element
                js.executeScript("arguments[0].scrollIntoView();", elements.get(elements.size()-1));
                wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.tagName("ytd-video-renderer"), elements.size()));
            } catch (TimeoutException e) {
                break;
            }
        }
        System.out.println("Finished!");

    }
}
