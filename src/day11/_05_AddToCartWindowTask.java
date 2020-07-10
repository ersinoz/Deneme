package day11;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseDriver;

import java.util.Set;

public class _05_AddToCartWindowTask extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.snapdeal.com/");
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // click on any product
        driver.findElement(By.cssSelector(".trendingProd:not(.bx-clone) > a")).click();
        // switch to new window that was opened
        String mainWindowHandle = driver.getWindowHandle();
        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle: windowHandles){
            if(!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
            }
        }
        // store the product name
        String productName = driver.findElement(By.cssSelector("h1[itemprop=\"name\"]")).getText();
        // click on add to cart
        driver.findElement(By.id("add-cart-button-id")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".mess-container")));
        // close the window
        driver.close();
        // switch back to main window
        driver.switchTo().window(mainWindowHandle);
        // click on the cart
        driver.findElement(By.cssSelector(".cartContainer")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#rtbScriptContainer")));
        // verify that cart contains you product by name
        String actualProductName = driver.findElement(By.cssSelector(".item-name")).getText();
        Assert.assertEquals(productName, actualProductName);

        driver.quit();
    }
}
