package day9;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utils.BaseStaticDriver;

public class _05_ActionTypingYourName extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("https://demoqa.com/auto-complete");
        WebElement textInput = driver.findElement( By.id( "autoCompleteSingleContainer" ) );
        Actions actions = new Actions( driver );
        actions
                .moveToElement( textInput )
                .click()
                .keyDown( Keys.SHIFT )
                .sendKeys( "b" )
                .keyUp( Keys.SHIFT )
                .sendKeys( "ehruz" )
                .perform();
    }

}
