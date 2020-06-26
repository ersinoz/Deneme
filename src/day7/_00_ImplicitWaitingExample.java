package day7;

import org.openqa.selenium.By;
import utils.BaseDriver;

import java.util.concurrent.TimeUnit;

public class _00_ImplicitWaitingExample extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        // without this timeout, the below code will throw exception right away
        // if the below element is found after 3 seconds, this code will continue right away
        System.out.println(driver.findElement(By.id("name-and-slogan2")).getText());
    }

}
