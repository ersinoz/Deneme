package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.BaseDriver;

public class _03_ActionRightClickTest extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://demoqa.com/buttons");

        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));

        Actions builder = new Actions(driver);
        Action build = builder.contextClick(clickButton).build();
        build.perform();

        String dynamicClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals("You have done a right click", dynamicClickMessage);
    }

}
