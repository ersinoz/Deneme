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
        Double operand1 = 1.0;
        Double operand2 = 1.0;
        for (WebElement operation : operations.getOptions()) {
            if (operation.getText().equals("Concatenate")) {
                String answer = calculate(operand1.toString(), operand2.toString(), operation.getText());
                String expected = operand1.toString() + operand2.toString();
                Assert.assertEquals(expected, answer);
            } else {
                Double answer = calculate(operand1, operand2, operation.getText());
                if (operation.getText().equals("Add")) {
                    Assert.assertEquals((operand1 + operand2), answer, 0.00001);
                } else if (operation.getText().equals("Subtract")) {
                    Assert.assertEquals((operand1 - operand2), answer, 0.00001);
                } else if (operation.getText().equals("Multiply")) {
                    Assert.assertEquals((operand1 * operand2), answer, 0.00001);
                } else if (operation.getText().equals("Divide")) {
                    Assert.assertEquals((operand1 / operand2), answer, 0.00001);
                }
            }

        }
        driver.quit();
    }

    private static Double calculate(Double operand1, Double operand2, String operation) throws InterruptedException {
        WebElement number1Field = driver.findElement(By.id("number1Field"));
        number1Field.clear();
        number1Field.sendKeys(operand1.toString());
        WebElement number2Field = driver.findElement(By.id("number2Field"));
        number2Field.clear();
        number2Field.sendKeys(operand2.toString());
        Select operations = new Select(driver.findElement(By.id("selectOperationDropdown")));
        operations.selectByVisibleText(operation);
        driver.findElement(By.id("calculateButton")).click();
        Thread.sleep(1000); // should be done explicit wait
        String value = driver.findElement(By.id("numberAnswerField")).getAttribute("value");
        return Double.parseDouble(value);

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
