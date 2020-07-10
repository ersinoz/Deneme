package day6;


import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BaseStaticDriver;

import java.util.ArrayList;
import java.util.List;

public class _09_GoToCheckoutPageTest3 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com/");
        login("standard_user", "secret_sauce");
        String result = goToCheckoutPage("Dogan", "", "1234");
        Assert.assertEquals("Error: Last Name is required", result);
        driver.quit();
    }

    // go to checkout page
    private static String goToCheckoutPage(String firstName, String lastName, String zipCode) {
        driver.findElement(By.xpath("//a[contains(@class,'shopping_cart')]")).click();
        driver.findElement(By.xpath("//a[contains(@class,'btn_action')]")).click();
        driver.findElement(By.xpath("//input[@id='first-name']")).sendKeys(firstName);
        driver.findElement(By.xpath("//input[@id='last-name']")).sendKeys(lastName);
        driver.findElement(By.xpath("//input[@id='postal-code']")).sendKeys(zipCode);
        driver.findElement(By.xpath("//input[contains(@class,'btn_primary')]")).click();

        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals("https://www.saucedemo.com/checkout-step-two.html")) {
            return "success!";
        } else {
             return driver.findElement(By.xpath("//h3[@data-test=\"error\"]")).getText();
        }
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
    private static List<String> getTheListOfItems() {
        List<WebElement> items = driver.findElements(By.xpath("//div[@class='inventory_item_name']"));
        List<String> itemNames = new ArrayList<>();
        for (WebElement item: items) {
            itemNames.add(item.getText());
        }
        return itemNames;
    }
    
    // remove item from the cart
    // get the list of items in the cart
    // check prices in the checkout page
    // check tax in the checkout page
    // check thank you message
}
