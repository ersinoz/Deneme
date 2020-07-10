package day11;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Set;

public class _03_ClosingWindows extends BaseStaticDriver {
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
            if(!handle.equals(mainWindowHandle)) { // we are already focused on main window, so no need to switch to it again
                driver.switchTo().window(handle); // driver gains new focus here
                System.out.println("Window Title: " +  driver.getTitle());
                driver.close(); // driver loses focus here. the focus DOES NOT go to main window
            }
        }

        // need to gain focus again by using switchTo()
        driver.switchTo().window(mainWindowHandle); // without this, driver will not have focus and it will throw error
        System.out.println("Window Title: " +  driver.getTitle());
        driver.quit();
    }

}
