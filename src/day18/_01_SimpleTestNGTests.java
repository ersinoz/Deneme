package day18;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.util.Random;

public class _01_SimpleTestNGTests {

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
        System.out.println("Before each method!");
    }

    @AfterMethod
    void cleanUp(){
        System.out.println("After each method!");
    }

    @BeforeClass
    void beforeClass() {
        System.out.println("Before class!");
    }

    @AfterClass
    void afterClass() {
        System.out.println("After Class!");
    }
}
