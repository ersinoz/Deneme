package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _03_TestingAMethod {

    @Test
    void testCase1() {
        Double aDouble = getDoubleFromText("$14.50");
        Assert.assertEquals(aDouble, 14.5);
    }

    @Test
    void testCase2() {
        Double aDouble = getDoubleFromText("USD 10.90");
        Assert.assertEquals(aDouble, 10.9);
    }

    @Test
    void testCase3() {
        Double aDouble = getDoubleFromText("10.90$");
        Assert.assertEquals(aDouble, 10.9);
    }

    @Test
    void testCase4() {
        Double aDouble = getDoubleFromText("10000000$");
        Assert.assertEquals(aDouble, 10000000.0);
    }

    private Double getDoubleFromText(String cartPriceText) {
        return Double.valueOf(cartPriceText.replaceAll( "[^\\d.]","" ));
    }
}
