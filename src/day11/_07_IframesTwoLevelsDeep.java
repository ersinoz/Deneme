package day11;

import org.openqa.selenium.By;
import utils.BaseDriver;

public class _07_IframesTwoLevelsDeep extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://chercher.tech/practice/frames");
        String label = driver.findElement(By.tagName("label")).getText();
        System.out.println("Label: " +  label);

        driver.switchTo().frame("frame1");
        String topic = driver.findElement(By.id("topic")).getText();
        System.out.println("topic: " + topic);

        driver.switchTo().frame("frame3");
        System.out.println("B: " +  driver.findElement(By.tagName("b")).getText());


        driver.switchTo().defaultContent(); // bring me to main content
        System.out.println("Label: " +  driver.findElement(By.tagName("label")).getText());
    }
}
