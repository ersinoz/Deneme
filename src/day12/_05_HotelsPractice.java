package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

public class _05_HotelsPractice extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.hotels.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.cssSelector("input[name=\"q-destination\"]")).sendKeys("London");
        driver.findElement(By.cssSelector("form button.cta")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("listings")));

        for (int i = 0; i < 100; i++) {
            // scroll all the way down
            js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
            // wait for loading image to appear
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".listings-loading-circle")));
            // wait for loading image to disappear before continuing to scroll down
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".listings-loading-circle")));
        }

    }
}
