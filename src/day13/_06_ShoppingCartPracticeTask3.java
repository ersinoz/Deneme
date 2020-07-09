package day13;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class _06_ShoppingCartPracticeTask3 extends BaseDriver {
    public static void main(String[] args) {
        driver.get("http://practice.automationtesting.in/shop/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10); // the timeout of 5 seconds

        // add random number of items into the basket
        List<WebElement> items = driver.findElements(By.cssSelector(".instock"));
        int numberOfItems = 3;//new Random().nextInt(items.size()) + 1;
        System.out.println("numberOfItems: " + numberOfItems);

        List<String> namesOfItems =  new ArrayList<>();
        for (int i = 0; i < numberOfItems; i++) {
            try {
                String itemName = getNameOfAddedElement(wait, items, i);
                namesOfItems.add(itemName);
            } catch (StaleElementReferenceException  e){
                items = driver.findElements(By.cssSelector(".instock"));
                String itemName = getNameOfAddedElement(wait, items, i);
                namesOfItems.add(itemName);
            }

        }

        System.out.println("Added: ");
        for (String name: namesOfItems) {
            System.out.println(name);
        }

        // go to checkout page and fill out the form
        driver.navigate().to("http://practice.automationtesting.in/basket/");
        driver.findElement(By.cssSelector("a.checkout-button")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.className("woocommerce-billing-fields")));
        driver.findElement(By.id("billing_first_name")).sendKeys("My name");
        driver.findElement(By.id("billing_last_name")).sendKeys("My Last Name");
        driver.findElement(By.id("billing_email")).sendKeys("random@email.address");
        driver.findElement(By.id("billing_phone")).sendKeys("123456789");
        driver.findElement(By.id("billing_address_1")).sendKeys("My address");
        driver.findElement(By.id("billing_city")).sendKeys("My city");
        driver.findElement(By.id("billing_state")).sendKeys("My state");
        driver.findElement(By.id("billing_postcode")).sendKeys("12345");

        try {
            driver.findElement(By.id("place_order")).click();
        } catch (StaleElementReferenceException e) {
            driver.findElement(By.id("place_order")).click();
        }


        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".order_item > .product-name > a"), 0 ));
        List<WebElement> itemsInTheCart = driver.findElements(By.cssSelector(".order_item > .product-name > a"));

        Assert.assertEquals(numberOfItems, itemsInTheCart.size());

        for(WebElement itemInTheCart : itemsInTheCart) {
            String textOfItemInTheCart = itemInTheCart.getText();
            String errorMessage = textOfItemInTheCart + " is not in the expected list! " + namesOfItems;
            Assert.assertTrue(errorMessage, namesOfItems.contains(textOfItemInTheCart));
        }

        driver.quit();
    }

    private static String getNameOfAddedElement(WebDriverWait wait, List<WebElement> items, int i) {
        WebElement liItem = items.get(i);
        liItem.findElement(By.cssSelector("a.add_to_cart_button")).click();
        wait.until(ExpectedConditions.attributeContains(liItem.findElement(By.cssSelector("a.add_to_cart_button")), "class", "added"));
        return liItem.findElement(By.cssSelector("h3")).getText();
    }
}
