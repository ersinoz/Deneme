package day7;

import org.junit.Assert;
import org.openqa.selenium.By;
import utils.BaseDriver;

public class _05_PromptAlertTest1 extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.findElement(By.cssSelector("button[onclick='myPromptFunction()']")).click();

        // create a test string
        String testString = "Hello!";
        // switch to alert and send keys of test string to it
        driver.switchTo().alert().sendKeys(testString);
        // press accept on alert
        driver.switchTo().alert().accept();

        // find the result text on the website
        String actualText =driver.findElement(By.xpath("//p[@id='prompt-demo']")).getText();
        // confirm that the result test contains test string
        boolean contains = actualText.contains(testString);
        Assert.assertTrue("Actual text should contain the test string!", contains);
    }

}
