package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

import java.util.List;

public class _09_ActionHoverOverList2 extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.myntra.com");
        WebElement kidsMenu = driver.findElement(By.cssSelector("a[data-group=\"kids\"]"));
        Actions actions = new Actions(driver);
        actions.moveToElement(kidsMenu).perform();
        Thread.sleep(1000);

        List<WebElement> elements = driver.findElements(By.cssSelector("div.desktop-categoryContainer li"));
        for (WebElement element : elements ){
            if(element.isDisplayed()) {
                System.out.println(element.getText());
            }
        }
    }

}
