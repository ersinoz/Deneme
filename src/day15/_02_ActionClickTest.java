package day15;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_ActionClickTest {

    @Test
    void actionClickTestCase() {
        System.setProperty("webdriver.chrome.driver", "E:\\projects\\Selenium\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Click Me']"));

        Actions builder = new Actions(driver);
        Action build = builder.moveToElement(clickButton).click().build();
        build.perform();

        String dynamicClickMessage = driver.findElement(By.id("dynamicClickMessage")).getText();
        Assert.assertEquals("You have done a dynamic click", dynamicClickMessage);

        driver.quit();
    }

    @Test
    void actionDoubleClickTestCase() {
        System.setProperty("webdriver.chrome.driver", "E:\\projects\\Selenium\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Double Click Me']"));

        Actions builder = new Actions(driver);
        Action build = builder.doubleClick(clickButton).build();
        build.perform();

        String dynamicClickMessage = driver.findElement(By.id("doubleClickMessage")).getText();
        Assert.assertEquals("You have done a double click", dynamicClickMessage);

        driver.quit();
    }

    @Test
    void actionRightClickTest() {
        System.setProperty("webdriver.chrome.driver", "E:\\projects\\Selenium\\driver\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://demoqa.com/buttons");

        WebElement clickButton = driver.findElement(By.xpath("//button[text()='Right Click Me']"));

        Actions builder = new Actions(driver);
        Action build = builder.contextClick(clickButton).build();
        build.perform();

        String dynamicClickMessage = driver.findElement(By.id("rightClickMessage")).getText();
        Assert.assertEquals("You have done a right click", dynamicClickMessage);
        driver.quit();
    }
}
