package day6;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BaseDriver;

import java.util.ArrayList;
import java.util.List;

public class _06_AddToCartTest extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com/");
        login("standard_user", "secret_sauce");
        addToCart("Sauce Labs Backpack");
        addToCart("Sauce Labs Bolt T-Shirt");
        addToCart("Sauce Labs Onesie");
        int actual = getNumberOfItemsInTheCart();
        Assert.assertEquals(3, actual);
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
