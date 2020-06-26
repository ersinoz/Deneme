package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import utils.BaseDriver;

public class _03_SimpleAlert extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        //driver.findElement(By.xpath("//button[@onclick='myAlertFunction()']")).click();
        driver.findElement(By.cssSelector("button[onclick='myAlertFunction()']")).click();
        String alertText = driver.switchTo().alert().getText();
        System.out.println(alertText);
        driver.switchTo().alert().accept();
    }

}
