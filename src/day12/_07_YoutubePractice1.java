package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

import java.util.List;

public class _07_YoutubePractice1 extends BaseDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.youtube.com/results?search_query=selenium");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        for (int i = 0; i < 1000; i++) {
            List<WebElement> elements = driver.findElements(By.tagName("ytd-video-renderer"));
            System.out.println("results size: " + elements.size());
            // scroll into view the last element
            js.executeScript("arguments[0].scrollIntoView();", elements.get(elements.size()-1));
        }


    }
}
