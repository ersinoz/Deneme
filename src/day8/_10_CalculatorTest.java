package day8;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.BaseDriver;

import java.util.concurrent.TimeUnit;

public class _10_CalculatorTest extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        driver.findElement(By.id("number1Field")).sendKeys("1");
        driver.findElement(By.id("number2Field")).sendKeys("1");
        Select operations = new Select(driver.findElement(By.id("selectOperationDropdown")));
        operations.selectByVisibleText("Add");
        driver.findElement(By.id("calculateButton")).click();
        String answer = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
        Assert.assertEquals("2", answer);
        driver.quit();
    }

}
