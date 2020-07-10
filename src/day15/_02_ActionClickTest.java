package day15;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

public class _02_ActionClickTest {

    private WebDriver driver;
    private Actions builder;

    @BeforeClass
    void setup(){
        System.setProperty("webdriver.chrome.driver", "E:\\projects\\Selenium\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
        builder = new Actions(driver);
    }

    @AfterClass
    void closeDriver() {
        driver.quit();
    }

    @Test
    void actionClickTestCase() {
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));

        builder.moveToElement(clickButton).click().perform();

        String dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage")).getText();
        Assert.assertEquals("You have done a dynamic click", dynamicClickMessage);

    }

    @Test
    void actionDoubleClickTestCase() {
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Double Click Me']"));

        builder.doubleClick(clickButton).perform();

        String dynamicClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals("You have done a double click", dynamicClickMessage);
    }

    @Test
    void actionRightClickTest() {
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));

        builder.contextClick(clickButton).perform();

        String dynamicClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals("You have done a right click", dynamicClickMessage);
    }
}
