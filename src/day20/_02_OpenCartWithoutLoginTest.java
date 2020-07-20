package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utils.BaseDriver;
import utils.ReusableMethods;

import java.util.List;

public class _02_OpenCartWithoutLoginTest extends OpenCartDriver {

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
