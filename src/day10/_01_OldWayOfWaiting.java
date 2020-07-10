package day10;

import org.openqa.selenium.By;
import utils.BaseStaticDriver;

public class _01_OldWayOfWaiting extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");

        driver.findElement(By.cssSelector("#start > button")).click();
        Thread.sleep(5000);
        String text = driver.findElement(By.id("finish")).getText();
        System.out.println(text);

        driver.quit();
    }

}
