package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseDriver;

import java.util.List;
import java.util.Set;

public class _01_OpenWindows extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.selenium.dev/");
        String windowHandle = driver.getWindowHandle();
        System.out.println("Main Window Handle: " + windowHandle);

        List<WebElement> links = driver.findElements(By.cssSelector("a[target=_blank]"));
        for(WebElement link: links) {
            link.click();
        }

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle: windowHandles) {
            System.out.println(handle);
        }

        driver.quit();
    }

}
