package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

public class _05_HotelsPractice extends BaseDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.hotels.com/");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebDriverWait wait = new WebDriverWait(driver, 10);

        driver.findElement(By.cssSelector("input[name=\"q-destination\"]")).sendKeys("London");
        driver.findElement(By.cssSelector("form button.cta")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("listings")));

        // scroll all the way down
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");

    }
}
