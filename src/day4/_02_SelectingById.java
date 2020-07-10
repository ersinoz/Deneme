package day4;

import org.openqa.selenium.By;
import utils.BaseStaticDriver;

public class _02_SelectingById extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://formsmarts.com/form/yu?mode=h5");  // this will open the website and wait until full load
        driver.findElement(By.cssSelector("#u_Uj7_89585_1")).click();
    }
}
