package day15;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class _02_ActionClickTest {

    private WebDriver driver;

    @BeforeMethod
    void setup(){
        System.setProperty("webdriver.chrome.driver", "E:\\projects\\Selenium\\driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");
    }

    @AfterMethod
    void closeDriver() {
        driver.quit();
    }

    @Test
    void actionClickTestCase() {
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));

        Actions builder = new Actions(driver);
        Action build = builder.moveToElement(clickButton).click().build();
        build.perform();

        String dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage")).getText();
        Assert.assertEquals("You have done a dynamic click", dynamicClickMessage);

    }

    @Test
    void actionDoubleClickTestCase() {
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Double Click Me']"));

        Actions builder = new Actions(driver);
        Action build = builder.doubleClick(clickButton).build();
        build.perform();

        String dynamicClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals("You have done a double click", dynamicClickMessage);
    }

    @Test
    void actionRightClickTest() {
        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));

        Actions builder = new Actions(driver);
        Action build = builder.contextClick(clickButton).build();
        build.perform();

        String dynamicClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals("You have done a right click", dynamicClickMessage);
    }
}
