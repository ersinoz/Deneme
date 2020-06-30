package day9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import utils.BaseDriver;

import java.util.List;

public class _07_ActionHoverOverTest extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        WebElement bankButton = driver.findElement(By.id("credit2"));
        Actions actions = (new Actions(driver)).moveToElement(bankButton);
        Thread.sleep(2000);
        // color before hover over
        String rgbaColor = bankButton.getCssValue("color");
        System.out.println(Color.fromString(rgbaColor).asHex());

        // hover over bankButton action
        actions.perform();
        Thread.sleep(2000);

        // color after hover over
        bankButton = driver.findElement(By.id("credit2"));
        rgbaColor = bankButton.getCssValue("color");
        System.out.println(Color.fromString(rgbaColor).asHex());

    }

}
