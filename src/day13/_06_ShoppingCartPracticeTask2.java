package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

import java.util.List;
import java.util.Random;

public class _06_ShoppingCartPracticeTask2 extends BaseDriver {
    public static void main(String[] args) {
        driver.get("http://practice.automationtesting.in/shop/");
        driver.manage().window().maximize();
        WebDriverWait wait = new WebDriverWait(driver, 10); // the timeout of 5 seconds

        // add random number of items into the basket
        List<WebElement> items = driver.findElements(By.cssSelector("a[class*='add_to_cart_button']"));
        Integer numberOfItems = new Random().nextInt(items.size()) + 1;
        System.out.println("numberOfItems: " + numberOfItems);
        for (int i = 0; i < numberOfItems; i++) {
            items.get(i).click();
            wait.until(ExpectedConditions.attributeContains(items.get(i), "class", "added"));
            items = driver.findElements(By.cssSelector("a[class*='add_to_cart_button']"));
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

        driver.findElement(By.id("place_order")).click();
    }
}
