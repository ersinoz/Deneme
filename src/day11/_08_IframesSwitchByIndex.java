package day11;

import org.openqa.selenium.By;
import utils.BaseDriver;

public class _08_IframesSwitchByIndex extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://chercher.tech/practice/frames");
        String label = driver.findElement(By.tagName("label")).getText();
        System.out.println("Label: " +  label);

        int numberOfIframes = driver.findElements(By.tagName("iframe")).size();
        System.out.println("numberOfIframes: " + numberOfIframes);

        for (int i = 0; i < numberOfIframes; i++) {
            driver.switchTo().frame(i);
            int numberOfNestedIframes = driver.findElements(By.tagName("iframe")).size();
            System.out.println("numberOfNestedIframes: " + numberOfNestedIframes);
            driver.switchTo().parentFrame(); // if i dont do this, will be switch inside nested iframe
        }

    }
}
