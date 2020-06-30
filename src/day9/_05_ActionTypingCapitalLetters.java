package day9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseDriver;

import java.security.Key;
import java.util.List;

public class _05_ActionTypingCapitalLetters extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://demoqa.com/auto-complete");
        WebElement textInput = driver.findElement(By.id("autoCompleteMultipleContainer"));
        Actions builder = new Actions(driver);
        builder
                .moveToElement(textInput)
                .click()
                .keyDown(Keys.SHIFT)
                .sendKeys("hello")
                .keyUp(Keys.SHIFT)
                .sendKeys("hello")
                .perform();
    }

}
