package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseDriver;

public class _04_LoginTest extends BaseDriver {

    @BeforeClass
    void goToWebsite() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
    }

    @Test
    void loginTestCase() {
        // test12345asd@test.com
        // qwerty12345

        //input the email
        driver.findElement(By.cssSelector("#input-email")).sendKeys("test12345asd@test.com");
        //input the password
        driver.findElement(By.cssSelector("#input-password")).sendKeys("qwerty12345");
        //click on login
        driver.findElement(By.cssSelector("input[value=\"Login\"]")).click();
        //verify that you are logged in
        String title = driver.getTitle();
        Assert.assertEquals(title, "My Account");
    }


}
