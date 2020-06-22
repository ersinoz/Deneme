package day4;

import org.openqa.selenium.By;
import utils.BaseDriver;

public class _02_SelectingById extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://formsmarts.com/form/yu?mode=h5");  // this will open the website and wait until full load
        driver.findElement(By.cssSelector("#u_Uj7_4586_1")).click();
    }
}
