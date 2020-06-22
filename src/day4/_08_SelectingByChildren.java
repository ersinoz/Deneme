package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseDriver;

import java.util.List;

public class _08_SelectingByChildren extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://formsmarts.com/form/yu?mode=h5");  // this will open the website and wait until full load

        // inside section_1 find me second radio group
        // String cssSelector = "#section_1>fieldset:nth-of-type(2)";
        // String cssSelector = "#section_1>[role=radiogroup]:nth-of-type(2)";
        String cssSelector = "#section_1>.radio-w:nth-of-type(2)";

        WebElement element = driver.findElement(By.cssSelector(cssSelector));
        System.out.println(element.getText());

    }
}
