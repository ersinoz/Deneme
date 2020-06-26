package day7;

import org.openqa.selenium.By;
import utils.BaseDriver;

import java.util.concurrent.TimeUnit;

public class _01_ThreadSleepExample extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        Thread.sleep(5000);
        // wait for 5 seconds no matter what, even if the below element is already present and ready to be found
        System.out.println(driver.findElement(By.id("name-and-slogan2")).getText());
    }

}
