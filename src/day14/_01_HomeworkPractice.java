package day14;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _01_HomeworkPractice extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://pwa-woo.wpmobilepack.com/#/category/88");
        WebDriverWait wait = new WebDriverWait(driver, 5); // the timeout of 5 seconds
        List<String> namesOfItems =  new ArrayList<>();

        goToRandomItem(wait);
        String firstItemName = getNameAndAddToCart(wait);
        namesOfItems.add(firstItemName);

        driver.navigate().back();

        goToRandomItem(wait);
        String secondItemName = getNameAndAddToCart(wait);
        namesOfItems.add(secondItemName);

        driver.findElement(By.cssSelector(".cart-link")).click();
        List<WebElement> cartItems = driver.findElements(By.cssSelector(".content .centered > .break-words"));
        for (WebElement cartItem : cartItems) {
            String textOfItemInTheCart = cartItem.getText();
            String errorMessage = textOfItemInTheCart + " is not in the expected list! " + namesOfItems;
            Assert.assertTrue(errorMessage, namesOfItems.contains(textOfItemInTheCart));
        }
    }

    private static String getNameAndAddToCart(WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pusher .header")));
        String itemName = driver.findElement(By.cssSelector(".pusher .header")).getText();
        System.out.println("itemName: " + itemName);

        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[role=\"listbox\"]")));
            List<WebElement> dropDownBoxes = driver.findElements(By.cssSelector("[role=\"listbox\"]"));
            for (WebElement dropDown : dropDownBoxes) {
                dropDown.click();
                dropDown.sendKeys(Keys.ENTER);
            }
        } catch (TimeoutException e) {
            System.out.println("No dropdowns, continue");
        }
        driver.findElement(By.cssSelector(".card button[role=button]")).click();
        driver.findElement(By.cssSelector(".close-toastr")).click();
        return itemName;
    }

    private static void goToRandomItem(WebDriverWait wait) {
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".infinite-scroll-component button"), 0));
        List<WebElement> items = driver.findElements(By.cssSelector(".infinite-scroll-component button"));
        System.out.println("items size: " + items.size());
        int randomItem = new Random().nextInt(items.size());
        items.get(randomItem).click();
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
