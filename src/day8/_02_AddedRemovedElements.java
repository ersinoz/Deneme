package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _02_AddedRemovedElements extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement button = driver.findElement(By.cssSelector("button[onclick=\"addElement()\"]"));
        button.click();
        WebElement element = driver.findElement(By.cssSelector("button[class=\"added-manually\"]"));
        System.out.println("element is displayed: " + element.isDisplayed());
    }

}
