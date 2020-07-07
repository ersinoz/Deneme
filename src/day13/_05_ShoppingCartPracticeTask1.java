package day13;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseDriver;

import java.util.List;
import java.util.Random;

public class _05_ShoppingCartPracticeTask1 extends BaseDriver {
    public static void main(String[] args) {
        driver.get("http://practice.automationtesting.in/shop/");
        // add random number of items into the basket
        List<WebElement> items = driver.findElements(By.cssSelector("a[class*='add_to_cart_button']"));
        Integer numberOfItems = new Random().nextInt(items.size()) + 1;
        System.out.println("numberOfItems: "+numberOfItems);
        for (int i = 0; i < numberOfItems; i++) {
            items.get(i).click();
            items = driver.findElements(By.cssSelector("a[class*='add_to_cart_button']"));
        }

    }
}
