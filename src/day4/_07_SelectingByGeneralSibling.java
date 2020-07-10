package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _07_SelectingByGeneralSibling extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://formsmarts.com/form/yu?mode=h5");  // this will open the website and wait until full load

       // using general sibling selector print all options of "How often do you use XYZ?" question
        List<WebElement> elements = driver.findElements(By.cssSelector("#u_Uj7_89585_lbl ~ label"));
        for(WebElement element : elements) {
            System.out.println(element.getText());
        }

    }
}
