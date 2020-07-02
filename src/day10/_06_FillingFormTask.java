package day10;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

import java.util.concurrent.TimeUnit;

public class _06_FillingFormTask extends BaseDriver {
    public static void main(String[] args)  {
        driver.get("https://www.seleniumeasy.com/test/ajax-form-submit-demo.html");

        driver.findElement(By.id("title")).sendKeys("Dogan");
        driver.findElement(By.id("description")).sendKeys("Dogan");
        driver.findElement(By.id("btn-submit")).click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.textToBe(By.id("submit-control"), "Form submited Successfully!"));

        String text = driver.findElement(By.id("submit-control")).getText();
        Assert.assertEquals("Form submited Successfully!",text);

        driver.quit();
    }

}
