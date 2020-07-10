package day15;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.Test;

import java.util.Random;

public class _01_TestNGIntro {

    @Test
    void testCase1() {
        Assert.assertEquals("test", "test");
    }

    @Test
    void testCase2() {
        boolean failCondition = true;
        if(failCondition) {
            Assert.fail("This test fail because of some condition!");
        }
    }

    @Test
    void testCase3() {
        boolean dataIsAvailable = new Random().nextBoolean();
        if(!dataIsAvailable) {
            throw new SkipException("Data required for test is not available!");
        }
    }
}
