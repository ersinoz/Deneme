package POMFiles;

import Utils.Driver;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Parent {
    WebDriverWait wait;
    WebDriver driver;


    public Parent() {
        driver = Driver.getDriver();
        wait = new WebDriverWait(driver,5);
    }

    public  void waitAndSendKeys(WebElement element, String text){

        wait.until(ExpectedConditions.visibilityOf(element)).clear();
        element.sendKeys(text);

    }
    public void waitAndClick(WebElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }
    //check it out pages
}
