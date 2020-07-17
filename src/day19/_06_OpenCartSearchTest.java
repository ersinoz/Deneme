package day19;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseDriver;
import utils.ReusableMethods;

import java.util.List;

public class _06_OpenCartSearchTest extends BaseDriver {

    private ReusableMethods methods;

    @BeforeClass(alwaysRun = true)
    void goToWebsite() {
        methods = new ReusableMethods(wait, driver, js);
        driver.get("https://opencart.abstracta.us/index.php");
        try {
            driver.findElement(By.id("details-button")).click();
            driver.findElement(By.id("proceed-link")).click();
        } catch (Exception e) {
            // this means there's no "Your connection is not private" page!
        }
    }

    @Test()
    void searchTestCase(){
        // type iphone in search bar
        driver.findElement(By.cssSelector("#search > input")).sendKeys("iphone");
        driver.findElement(By.cssSelector(".fa-search")).click();
        // validate that result have iphone in their product title
        List<WebElement> elements = driver.findElements(By.cssSelector(".product-thumb h4"));
        methods.verifyAllContainsText(elements, "iphone");
    }

}
