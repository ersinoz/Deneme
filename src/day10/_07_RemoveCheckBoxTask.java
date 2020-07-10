package day10;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BaseDriver;

public class _07_RemoveCheckBoxTask extends BaseDriver {
    public static void main(String[] args)  {
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebDriverWait wait = new WebDriverWait(driver, 5);

        // assert that checkbox exists
        driver.findElement(By.cssSelector("input[type=checkbox]"));

        // click on the remove button
        driver.findElement(By.cssSelector("#checkbox-example>button")).click();

        // assert that check box removed, this test is enough
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector("input[type=checkbox]")));
        // just additional test
        WebElement goneText = driver.findElement(By.cssSelector("#checkbox-example>p"));
        Assert.assertEquals("It's gone!", goneText.getText());

        // click on the add button
        driver.findElement(By.cssSelector("[onclick=\"swapCheckbox()\"]")).click();

        // assert that check box re-appeared, this test is enough
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[type=checkbox]")));
        // just additional test
        WebElement appearText = driver.findElement(By.cssSelector("#checkbox-example>p"));
        Assert.assertEquals("It's back!", appearText.getText());
    }

}
