package day4;

import org.openqa.selenium.By;
import utils.BaseStaticDriver;

public class _04_FacebookLogin extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.facebook.com/");  // this will open the website and wait until full load
        driver.findElement(By.cssSelector("#email")).sendKeys("info@techno.study");
        driver.findElement(By.cssSelector("#pass")).sendKeys("info@techno.study");
        driver.findElement(By.cssSelector("#u_0_b")).click();
    }
}
