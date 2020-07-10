package day9;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import utils.BaseDriver;

import java.util.List;

public class _04_ActionDragAndDropTest extends BaseDriver {
    public static void main(String[] args) {
        driver.get("http://demo.guru99.com/test/drag_drop.html");

        WebElement bankButton = driver.findElement(By.id("credit2"));
        WebElement dropZone = driver.findElement(By.id("bank"));
        (new Actions(driver)).dragAndDrop(bankButton, dropZone).perform();

        List<WebElement> elements = driver.findElements(By.cssSelector("#bank > li"));
        boolean found = false;
        for (WebElement element : elements) {
            String elementText = element.getText();
            if (elementText.equals(bankButton.getText())) {
                found = true;
                break;
            }
        }

        Assert.assertTrue(found, "Could not find bank in dropzone");
    }

}
