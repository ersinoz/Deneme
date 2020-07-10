package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _10_IframeSwitchToByWebElement extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://chercher.tech/practice/frames");
        WebElement iframe = driver.findElement(By.cssSelector("[name=\"iamframe\"]"));
        driver.switchTo().frame(iframe);
        driver.findElement(By.tagName("input")).sendKeys("Hello World!");

//        driver.quit();
    }

}
