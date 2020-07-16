package day18.practiceClasses;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _Practice2 {

    @Test(priority = 4)
    void testCase1() {
        Double aDouble = getDoubleFromText("$14.50");
        Assert.assertEquals(aDouble, 14.5);
    }

    @Test(priority = 3)
    void testCase2() {
        Double aDouble = getDoubleFromText("USD 10.90");
        Assert.assertEquals(aDouble, 10.9);
    }

    @Test(priority = 2)
    void testCase3() {
        Double aDouble = getDoubleFromText("10.90$");
        Assert.assertEquals(aDouble, 10.9);
    }

    @Test(priority = 1)
    void testCase4() {
        Double aDouble = getDoubleFromText("10000000$");
        Assert.assertEquals(aDouble, 10000000.0);
    }

    @Test(expectedExceptions = NumberFormatException.class, priority = 5)
    void testCase5() {
        getDoubleFromText("");
    }

    private Double getDoubleFromText(String cartPriceText) {
        return Double.valueOf(cartPriceText.replaceAll( "[^\\d.]","" ));
    }
}
