package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _06_ActionSelectingBlack extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://demoqa.com/auto-complete");
        WebElement textInput = driver.findElement(By.id("autoCompleteMultipleContainer"));
        Actions builder = new Actions(driver);
        builder
                .moveToElement(textInput)
                .click()
                .sendKeys("b").perform();
        Thread.sleep(200); // TODO: should use explicit waiting instead
        builder.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

}
