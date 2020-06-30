package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import utils.BaseDriver;

public class _08_ActionHoverOverList extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.etsy.com/");
        WebElement clothingMenu = driver.findElement(By.id("catnav-primary-link-10923"));
        Actions actions = new Actions(driver);
        actions.moveToElement(clothingMenu).perform();
        Thread.sleep(1000);

        WebElement kidsMenu = driver.findElement(By.id("side-nav-category-link-10941"));
        actions.moveToElement(kidsMenu).perform();
        Thread.sleep(1000);


    }

}
