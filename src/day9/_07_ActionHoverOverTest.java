package day9;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import utils.BaseDriver;

import java.util.List;

public class _07_ActionHoverOverTest extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/drag_drop.html");
        WebElement e = driver.findElement(By.cssSelector("li.ui-draggable:first-child > a"));
        Actions actionsBuilder = new Actions(driver);
        Action action = actionsBuilder.moveToElement(e).click().build();
        System.out.println("Before hover: " + Color.fromString(e.getCssValue("color")).asHex());
        action.perform();
        System.out.println("After hover: " + Color.fromString(e.getCssValue("color")).asHex());

        // be careful, the css property value should be applied to the web element that you are inspecting
        // if you select #credit2 element which is actually a li element, the style is not applied to it
        // on this website the style of color change on hover is applied to a element, not li element
    }

}
