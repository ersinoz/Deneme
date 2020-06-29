package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import utils.BaseDriver;

public class _01_Visible extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.w3schools.com/howto/howto_js_toggle_hide_show.asp");

        // present and visible
        WebElement visibleButton = driver.findElement(By.cssSelector("button[onclick=\"myFunction()\"]"));
        System.out.println("visibleButton is displayed: " + visibleButton.isDisplayed());
        // present and invisible
        visibleButton.click();
        WebElement myDiv = driver.findElement(By.id("myDIV"));
        System.out.println("myDiv is displayed: " + myDiv.isDisplayed());
        // absent
        try {
            WebElement myDiv2 = driver.findElement(By.id("myDIV2"));
        } catch (NoSuchElementException e) {
            System.out.println("myDiv2 is absent!");
        }
        driver.quit();
    }

}
