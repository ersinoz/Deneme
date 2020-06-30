package day9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import utils.BaseDriver;

public class _02_ActionDoubleClickTest extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://demoqa.com/buttons");

        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Double Click Me']"));

        Actions builder = new Actions(driver);
        Action build = builder.doubleClick(clickButton).build();
        build.perform();

        String dynamicClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals("You have done a double click", dynamicClickMessage);
    }

}
