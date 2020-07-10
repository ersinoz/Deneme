package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.BaseStaticDriver;

public class _09_IframesGetAllNested extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://chercher.tech/practice/frames");
        getAllNestedFrames(driver, 0);
        driver.quit();
    }
    // recursive method
    private static void getAllNestedFrames(WebDriver driver, int level) {
        int size = driver.findElements(By.tagName("iframe")).size();
        level++;
        System.out.println("level "+level + " nested frames size: " + size);
        if(size > 0) {
            for (int i = 0; i < size; i++) {
                driver.switchTo().frame(0);
                getAllNestedFrames(driver, level);
                driver.switchTo().parentFrame();
            }
        }
    }
}
