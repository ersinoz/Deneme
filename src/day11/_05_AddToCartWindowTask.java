package day11;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseDriver;

import java.util.Set;

public class _05_AddToCartWindowTask extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.snapdeal.com/");
        // click on any product
        // switch to new window that was opened
        // store the product name
        // click on add to cart
        // close the window
        // switch back to main window
        // click on the cart
        // verify that cart contains you product
    }
}
