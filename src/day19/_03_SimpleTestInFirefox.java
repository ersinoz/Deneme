package day19;


import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseDriver;

import java.util.List;

public class _03_SimpleTestInFirefox  {
    private WebDriver driver;

    @BeforeClass
    public void setup() {
        // get from https://github.com/mozilla/geckodriver/releases
        System.setProperty("webdriver.gecko.driver", "E:\\projects\\Selenium\\driver\\geckodriver.exe");
        driver = new FirefoxDriver();
    }

    @Test(groups = "smoke")
    public void mainTestCase() {
        driver.get("https://pwa-woo.wpmobilepack.com/#/product/1297"); //with checkboxes
//        driver.get("https://pwa-woo.wpmobilepack.com/#/product/1295"); //without checkboxes
        WebDriverWait wait = new WebDriverWait(driver, 5); // the timeout of 5 seconds
        getNameAndAddToCart(wait);
    }

    private String getNameAndAddToCart(WebDriverWait wait) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".pusher .header")));
        String itemName = driver.findElement(By.cssSelector(".pusher .header")).getText();
        System.out.println("itemName: " + itemName);

        try {
            driver.findElement(By.cssSelector(".loader"));
            try {
                System.out.println("there is loader, expecting checkboxes, need to wait");
                wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("[role=\"listbox\"]")));
                List<WebElement> dropDownBoxes = driver.findElements(By.cssSelector("[role=\"listbox\"]"));
                for (WebElement dropDown : dropDownBoxes) {
                    dropDown.click();
                    dropDown.sendKeys(Keys.ENTER);
                }
            } catch (TimeoutException e) {
                Assert.fail("I expected checkboxes, but there arent any!");
            }
        } catch (NoSuchElementException e) {
            System.out.println("there is no loader, no checkboxes, don't need to wait");
        }

        driver.findElement(By.cssSelector(".card button[role=button]")).click();
        driver.findElement(By.cssSelector(".close-toastr")).click();
        return itemName;
    }
}
