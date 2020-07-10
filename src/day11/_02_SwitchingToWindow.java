package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Set;

public class _02_SwitchingToWindow extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.selenium.dev/");
        String mainWindowHandle = driver.getWindowHandle();
        System.out.println("Main Window Handle: " + mainWindowHandle);

        List<WebElement> links = driver.findElements(By.cssSelector("a[target=_blank]"));
        for(WebElement link: links) {
            link.click();
        }

        Set<String> windowHandles = driver.getWindowHandles();
        for (String handle: windowHandles) {
            System.out.println(handle);
            // we are already focused on main window
            // so don't need to switch to it again
            if(!handle.equals(mainWindowHandle)) {
                driver.switchTo().window(handle);
                System.out.println("Window Title: " +  driver.getTitle());
            }
        }

        driver.quit();
    }

}
