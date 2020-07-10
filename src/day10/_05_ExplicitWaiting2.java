package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseStaticDriver;

public class _05_ExplicitWaiting2 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
        WebDriverWait wait = new WebDriverWait(driver, 10); // the timeout of 5 seconds

        driver.findElement(By.cssSelector("#start > button")).click();

        // wait until web element is present
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("finish")));

        // if element is present then continue
        String text = driver.findElement(By.id("finish")).getText();
        System.out.println(text);

        driver.quit();
    }

}
