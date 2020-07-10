package day11;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BaseStaticDriver;

import java.util.Set;

public class _04_NewWindowsTask extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://demoqa.com/browser-windows");
        // click on the new window button, and verify that in new windows you have text: "This is a sample page"
        String mainWindow = driver.getWindowHandle();

        // click on the new window button
        driver.findElement(By.id("tabButton")).click();

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle: windowHandles) {
            if(!handle.equals(mainWindow)) {
                driver.switchTo().window(handle);
                WebElement sampleHeading = driver.findElement(By.id("sampleHeading"));
                Assert.assertEquals("This is a sample page", sampleHeading.getText());
            }
        }
    }
}
