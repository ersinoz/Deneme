package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseDriver;

public class _04_LoginTest extends BaseDriver {

    private String email;
    private String password;

    @BeforeClass
    void goToWebsite() {
        email = "test12345asda@test.com";
        password = "someRassword123";
        driver.get("https://opencart.abstracta.us/index.php");
        driver.findElement(By.id("details-button")).click();
        driver.findElement(By.id("proceed-link")).click();
    }

    @Test(priority = 2)
    void loginTestCase() {
        driver.navigate().to("https://opencart.abstracta.us/index.php?route=account/login");
        // test12345asd@test.com
        // qwerty12345

        //input the email
        driver.findElement(By.cssSelector("#input-email")).sendKeys(email);
        //input the password
        driver.findElement(By.cssSelector("#input-password")).sendKeys("qwerty12345");
        //click on login
        driver.findElement(By.cssSelector("input[value=\"Login\"]")).click();
        //verify that you are logged in
        String title = driver.getTitle();
        Assert.assertEquals(title, "My Account");
    }

    @Test(priority = 1)
    void createAccountTest() {
        driver.navigate().to("https://opencart.abstracta.us/index.php?route=account/register");

        driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Name");
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Last Name");
        driver.findElement(By.cssSelector("#input-email")).sendKeys(email);
        driver.findElement(By.cssSelector("#input-telephone")).sendKeys("12345679812");
        driver.findElement(By.cssSelector("#input-address-1")).sendKeys("Last Name");
        driver.findElement(By.cssSelector("#input-city")).sendKeys("Last Name");
        driver.findElement(By.cssSelector("#input-postcode")).sendKeys("123123");
        Select country = new Select(driver.findElement(By.cssSelector("#input-country")));
        country.selectByIndex(3);
        WebDriverWait wait = new WebDriverWait(driver, 12);
        // TODO: find correct condition for this
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".fa-spin")));
        Select region = new Select(driver.findElement(By.cssSelector("#input-zone")));
        country.selectByIndex(2);
        driver.findElement(By.cssSelector("#input-password")).sendKeys(password);
        driver.findElement(By.cssSelector("#input-confirm")).sendKeys(password);
        driver.findElement(By.cssSelector("[name=\"agree\"]")).click();
        driver.findElement(By.cssSelector("[value=\"Continue\"]")).click();
        //verify that you are logged in
        String title = driver.getTitle();
        Assert.assertEquals(title, "My Account");

        driver.findElement(By.cssSelector("a.list-group-item[href*=logout]")).click();

    }

}
