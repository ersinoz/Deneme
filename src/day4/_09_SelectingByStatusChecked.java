package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _09_SelectingByStatusChecked extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://formsmarts.com/form/yu?mode=h5");  // this will open the website and wait until full load

        List<WebElement> allCheckedElementsBefore = driver.findElements(By.cssSelector("input:checked"));
        System.out.println("allCheckedElementsBefore: " + allCheckedElementsBefore.size());
        for(WebElement element : allCheckedElementsBefore) {
            System.out.println(element.getAttribute("value"));
        }

        String cssSelector = "#u_bD9_89585_1";
        driver.findElement(By.cssSelector(cssSelector)).click();
        List<WebElement> allCheckedElementsAfter = driver.findElements(By.cssSelector("input:checked"));
        System.out.println("allCheckedElementsAfter: " + allCheckedElementsAfter.size());
        for(WebElement element : allCheckedElementsAfter) {
            System.out.println(element.getAttribute("value"));
        }

    }
}
