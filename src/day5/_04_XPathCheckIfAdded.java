package day5;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import utils.BaseDriver;

public class _04_XPathCheckIfAdded extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.saucedemo.com/");

        // try to login
        driver.findElement(By.xpath("//input[@id='user-name']")).sendKeys("standard_user");
        driver.findElement(By.xpath("//input[@data-test='password']")).sendKeys("secret_sauce");
        driver.findElement(By.xpath("//input[@class='btn_action']")).click();

        // check if logged in by find cart element
        try {
            driver.findElement(By.xpath("//a[contains(@class,'shopping_cart')]"));
            System.out.println("Successfully logged in!");
        } catch (NoSuchElementException e) {
            System.out.println("Failed to log in!");
        }

        // add first item to cart
        driver.findElement(By.xpath("//a[@id='item_4_title_link']")).click();
        String firstItemName = driver.findElement(By.xpath("//div[@class='inventory_details_name']")).getText();
        String firstItemPrice = driver.findElement(By.xpath("//div[@class='inventory_details_price']")).getText();
        System.out.println("firstItemName: " + firstItemName);
        System.out.println("firstItemPrice: " + firstItemPrice);
        driver.findElement(By.xpath("//button[contains(@class,'btn_primary')]")).click();

        // check if added
        try {
            driver.findElement(By.xpath("//a[contains(@class,'shopping_cart')]//span[text()='1']"));
            System.out.println("Successfully added an element!");
        } catch (NoSuchElementException e) {
            System.out.println("Failed to an element!");
        }

        // navigate back
        // add second item to cart
        // check if added
        // go to checkout page
        // check the items names and their individual prices
        // check total
        // check tax is 8%
        // go to finish page and check thank you message

//        driver.quit();
    }
}
