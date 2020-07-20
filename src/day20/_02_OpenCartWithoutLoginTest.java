package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseDriver;
import utils.ReusableMethods;

import java.util.List;

public class _02_OpenCartWithoutLoginTest extends BaseDriver {

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

    @Test(dataProvider = "searchTermDataProvider")
    void searchTestCase(String searchTerm){
        System.out.println("initail searchterm: "+searchTerm);
        // type iphone in search bar
        methods.clearAndSendKeys(By.cssSelector("#search > input"), searchTerm);
        driver.findElement(By.cssSelector(".fa-search")).click();
        // validate that result have iphone in their product title
        List<WebElement> elements = driver.findElements(By.cssSelector(".product-thumb h4"));
        methods.verifyAllContainsText(elements, searchTerm);
    }

    @DataProvider(name = "searchTermDataProvider")
    public Object[][] data2() {
        return new Object[][]{
                {"iphone"},
                {"MacBook"},
                {"apple cinema"},
                {"Canon"}
        };
    }

}
