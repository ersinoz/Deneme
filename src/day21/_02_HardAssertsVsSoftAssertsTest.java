package day21;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_HardAssertsVsSoftAssertsTest {

    @Test()
    void hardAssert() {
        System.out.println("Before Hard Assert!");
        Integer[] actual = {1, 2, 3, 4};
        Integer[] expected = {1, 2, 3, 4};
        Assert.assertEquals(actual, expected, "Arrays are not equal by order");

        System.out.println("After Hard Assert!");
    }

    @Test()
    void hardAssertFailure() {
        System.out.println("Before Hard Assert!");
        Integer[] actual = {1, 2, 3, 4};
        Integer[] expected = {1, 2, 3, 5};
        Assert.assertEquals(actual, expected, "Arrays are not equal by order");

        System.out.println("After Hard Assert!");
    }


}
