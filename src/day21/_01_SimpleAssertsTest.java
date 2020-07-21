package day21;

import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_SimpleAssertsTest {

    @Test()
    void testCase1() {
        Integer[] actual = {1, 2, 3, 4};
        Integer[] expected = {1, 2, 3, 4};
        Assert.assertEquals(actual, expected, "Arrays are not equal by order");
    }

    @Test()
    void testCase2() {
        Integer[] actual = {1, 2, 3, 4};
        Integer[] expected = {1, 4, 3, 2};
        Assert.assertEquals(actual, expected, "Arrays are not equal by order");
    }

    @Test()
    void testCase3() {
        Integer[] actual = {1, 2, 3, 4};
        Integer[] expected = {1, 4, 3, 2};
        Assert.assertEqualsNoOrder(actual, expected, "Arrays are not equal");
    }

    @Test()
    void testCase4() {
        Integer[] actual = {1, 2, 3, 4};
        Integer[] expected = {1, 4, 3, 5};
        Assert.assertEqualsNoOrder(actual, expected, "Arrays are not equal");
    }
}
