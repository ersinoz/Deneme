package day14;


import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseStaticDriver;

import java.util.List;

public class _02_HomeworkPracticeHandlingDropdown extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://pwa-woo.wpmobilepack.com/#/product/1297"); //with checkboxes
//        driver.get("https://pwa-woo.wpmobilepack.com/#/product/1295"); //without checkboxes
        WebDriverWait wait = new WebDriverWait(driver, 5); // the timeout of 5 seconds
        getNameAndAddToCart(wait);
    }

    private static String getNameAndAddToCart(WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pusher .header")));
        String itemName = driver.findElement(By.cssSelector(".pusher .header")).getText();
        System.out.println("itemName: " + itemName);

        try {
            driver.findElement(By.cssSelector(".loader"));
            try {
                System.out.println("there is loader, expecting checkboxes, need to wait");
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[role=\"listbox\"]")));
                List<WebElement> dropDownBoxes = driver.findElements(By.cssSelector("[role=\"listbox\"]"));
                for (WebElement dropDown : dropDownBoxes) {
                    dropDown.click();
                    dropDown.sendKeys(Keys.ENTER);
                }
            } catch (TimeoutException e) {
                Assert.fail("I expected checkboxes, but there arent any!");
            }
        } catch (NoSuchElementException e) {
            System.out.println("there is no loader, no checkboxes, don't need to wait");
        }

        driver.findElement(By.cssSelector(".card button[role=button]")).click();
        driver.findElement(By.cssSelector(".close-toastr")).click();
        return itemName;
    }
}

//Navigate to  https://pwa-woo.wpmobilepack.com/#/category/88
//
//Add two random items to the cart
//    Get the name of the item
//
//Navigate to cart.
//    Verify name of the item is displayed in the cart.
//
//Total of two items should be equal to number next to Total text
//
//Note:
//  Some items have drop down you need to handle those drop down(s). Choose first option    from the dropdown.
//   Do not use Thread.sleep
//   Each item should be added one time.
//   To make sure your code is working run it at least 5 times.
