package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseDriver;

public class _01_DemoQA extends BaseDriver {

    private String username;
    private String password;

    @BeforeClass
    void goToWebsite() {
        username = "daulet";
        password = "DV@d9FjCm";
        driver.get("https://demoqa.com/books");
    }

    @Test()
    void loginTestCase() {
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("userName")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userName-value")));
        Assert.assertEquals(username,driver.findElement(By.cssSelector("#userName-value")).getText());
    }


}
