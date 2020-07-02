package day10;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BaseDriver;

public class _07_RemoveCheckBoxTask extends BaseDriver {
    public static void main(String[] args)  {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // assert that checkbox exists
        // click on the remove button
        // assert that check box removed
        // click on the add button
        // assert that check box re-appeared

    }

}
