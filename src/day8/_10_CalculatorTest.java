package day8;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.BaseDriver;

public class _10_CalculatorTest extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        String answer = calculate("1", "1", "Subtract");
        Assert.assertEquals("0", answer);
        driver.quit();
    }

    private static String calculate(String operand1, String operand2, String operation) {
        driver.findElement(By.id("number1Field")).sendKeys(operand1);
        driver.findElement(By.id("number2Field")).sendKeys(operand2);
        Select operations = new Select(driver.findElement(By.id("selectOperationDropdown")));
        operations.selectByVisibleText(operation);
        driver.findElement(By.id("calculateButton")).click();
        return driver.findElement(By.id("numberAnswerField")).getAttribute("value");

    }

}
