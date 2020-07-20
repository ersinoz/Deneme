package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
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

    // task 5
    @Test
    public void contactUsTest() {
        // go to contact us page
        driver.findElement(By.cssSelector("a[href*=contact]")).click();
        wait.until(ExpectedConditions.titleIs("Contact Us"));
        // fill in form click submit
        driver.findElement(By.cssSelector("#input-name")).sendKeys("AYSEGUL");
        driver.findElement(By.cssSelector("#input-email")).sendKeys("aa@gmail.com");
        driver.findElement(By.cssSelector("textarea[name='enquiry']")).sendKeys("blabla bla blabla");
        driver.findElement(By.cssSelector("input[value='Submit']")).click();
        // verify "Your enquiry has been successfully sent to the store owner!"
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("#content>p")));
        Assert.assertEquals("Your enquiry has been successfully sent to the store owner!",driver.findElement(By.cssSelector("#content>p")).getText());
    }
}
