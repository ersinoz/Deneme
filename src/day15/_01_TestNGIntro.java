package day15;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.util.Random;

public class _01_TestNGIntro {

    @Test
    void testCase1() {
        System.out.println("Successful test case 1");
        Assert.assertEquals("test", "test");
    }

    @Test
    void testCase2() {
        boolean failCondition = true;
        if(failCondition) {
            Assert.fail("This test case 2 fail because of some condition!");
        }
    }

    @Test
    void testCase3() {
        System.out.println("Sometimes successful test case 3");
        boolean dataIsAvailable = new Random().nextBoolean();
        if(!dataIsAvailable) {
            throw new SkipException("Data required for test is not available!");
        }
    }

    String someText;
    @Test
    void testCase4() {
        Assert.assertNotNull(someText);
    }

    @BeforeMethod
    void setup() {
        System.out.println("Initializing WebDriver!");
    }

    @AfterMethod
    void cleanUp(){
        System.out.println("Driver close!");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Run before all the test cases!");
    }

    @AfterClass
    void afterClass() {
        System.out.println("Run after all the test cases!");
    }
}
