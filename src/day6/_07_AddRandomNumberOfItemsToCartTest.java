package day6;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BaseDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _07_AddRandomNumberOfItemsToCartTest extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com/");
        login("standard_user", "secret_sauce");

        List<String> theListOfAvailableItems = getTheListOfItems();
        int numberOfAvailableItems = theListOfAvailableItems.size();
        int numberOfItemsToTest = new Random().nextInt(numberOfAvailableItems);

        for (int i = 0; i <= numberOfItemsToTest; i++) {
            addToCart(theListOfAvailableItems.get(i));
        }

        int actual = getNumberOfItemsInTheCart();
        Assert.assertEquals(numberOfItemsToTest, actual);
    }

    private static List<String> getTheListOfItems() {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> itemNames = new ArrayList<>();
        for (WebElement item: items) {
            itemNames.add(item.getText());
        }
        return itemNames;
    }


    // login function
    public static String login(String username, String password) {
        WebElement usernameInput = driver.findElement(By.xpath("//input[@id='user-name']"));
        usernameInput.clear();
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(By.xpath("//input[@data-test='password']"));
        passwordInput.clear();
        passwordInput.sendKeys(password);
        driver.findElement(By.xpath("//input[@class='btn_action']")).click();

        try {
            // check if logged in by find cart element
            driver.findElement(By.xpath("//a[contains(@class,'shopping_cart')]"));
            return "success";
        } catch (NoSuchElementException e) {
            try {
                // get the error message
                return driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
            } catch (NoSuchElementException error) {
                return "failure: error message not found!";
            }
        }
    }

    // add to cart function
    private static void addToCart(String itemName) {
        driver.findElement(By.xpath("//div[text()='" + itemName + "']//following::button")).click();
    }

    // get the number of items in the cart
    private static int getNumberOfItemsInTheCart() {
        try {
            String itemCountText = driver.findElement(By.xpath("//span[@class='fa-layers-counter shopping_cart_badge']")).getText();
            return Integer.parseInt(itemCountText);
        } catch (NoSuchElementException e) {
            return 0;
        }
    }

    // get the list of available items

    // remove item from the cart
    // get the list of items in the cart
    // go to checkout page
    // check prices in the checkout page
    // check tax in the checkout page
    // check thank you message
}
