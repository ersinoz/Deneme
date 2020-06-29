package day8;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseDriver;

public class _10_CalculatorTest extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://testsheepnz.github.io/BasicCalculator.html");
        Select operations = new Select(driver.findElement(By.id("selectOperationDropdown")));
        for (WebElement operation: operations.getOptions()) {
            String answer = calculate("1", "1", operation.getText());
            if(operation.getText().equals("Add")) {
                Assert.assertEquals("2", answer);
            } else if(operation.getText().equals("Subtract")) {
                Assert.assertEquals("0", answer);
            } else if(operation.getText().equals("Multiply")) {
                Assert.assertEquals("1", answer);
            } else if(operation.getText().equals("Divide")) {
                Assert.assertEquals("1", answer);
            } else if(operation.getText().equals("Concatenate")) {
                Assert.assertEquals("11", answer);
            }

        }
        driver.quit();
    }

    private static String calculate(String operand1, String operand2, String operation) throws InterruptedException {
        WebElement number1Field = driver.findElement(By.id("number1Field"));
        number1Field.clear();
        number1Field.sendKeys(operand1);
        WebElement number2Field = driver.findElement(By.id("number2Field"));
        number2Field.clear();
        number2Field.sendKeys(operand2);
        Select operations = new Select(driver.findElement(By.id("selectOperationDropdown")));
        operations.selectByVisibleText(operation);
        driver.findElement(By.id("calculateButton")).click();
        Thread.sleep(1000); // should be done explicit wait
        return driver.findElement(By.id("numberAnswerField")).getAttribute("value");

    }

}
