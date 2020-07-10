package day11;


import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

import java.util.Set;

public class _06_Iframes extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://chercher.tech/practice/frames");
        String label = driver.findElement(By.tagName("label")).getText();
        System.out.println("Label: " +  label);

        driver.switchTo().frame("frame1");
        String topic = driver.findElement(By.id("topic")).getText();
        System.out.println("topic: " + topic);

        driver.switchTo().parentFrame();
        System.out.println("Label: " +  driver.findElement(By.tagName("label")).getText());
    }
}
