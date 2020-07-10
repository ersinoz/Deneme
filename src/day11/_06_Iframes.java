package day11;


import org.openqa.selenium.By;
import utils.BaseStaticDriver;

public class _06_Iframes extends BaseStaticDriver {
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
