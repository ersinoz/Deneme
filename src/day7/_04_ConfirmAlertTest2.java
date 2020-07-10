package day7;


import org.openqa.selenium.By;
import org.testng.Assert;
import utils.BaseStaticDriver;

public class _04_ConfirmAlertTest2 extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.findElement(By.cssSelector("button[onclick='myConfirmFunction()']")).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().dismiss();
        String actualText = driver.findElement(By.id("confirm-demo")).getText();
        Assert.assertEquals("You pressed Cancel!", actualText);
    }

}
