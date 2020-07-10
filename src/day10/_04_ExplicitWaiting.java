package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

public class _04_ExplicitWaiting extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        WebDriverWait wait = new WebDriverWait(driver, 10); // the timeout of 5 seconds

        driver.findElement(By.cssSelector("#start > button")).click();

        // wait until web element is visible
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("finish"))));

        // if element is visible then continue
        String text = driver.findElement(By.id("finish")).getText();
        System.out.println(text);

        driver.quit();
    }

}
