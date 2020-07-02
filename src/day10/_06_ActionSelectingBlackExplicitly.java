package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseDriver;

public class _06_ActionSelectingBlackExplicitly extends BaseDriver {
    public static void main(String[] args)  {
        driver.get("https://demoqa.com/auto-complete");
        WebElement textInput = driver.findElement(By.id("autoCompleteMultipleContainer"));
        Actions builder = new Actions(driver);
        builder
                .moveToElement(textInput)
                .click()
                .sendKeys("b").perform();
        // wait explicitly

        builder.sendKeys(Keys.ARROW_DOWN)
                .sendKeys(Keys.ENTER)
                .perform();
    }

}
