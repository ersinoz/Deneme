package day18;


import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.*;

import java.util.Random;

public class _02_SimpleTestNGTests  extends CommonClass {

    @Test(groups = {"success"})
    void testCase1() {
        System.out.println("Successful test case 1");
    }

    @Test(groups = {"success"})
    void testCase2() {
        System.out.println("Successful test case 2");
    }

    @Test(groups = {"success"})
    void testCase3() {
        System.out.println("Successful test case 3");
    }

    @Test(groups = {"success"})
    void testCase4() {
        System.out.println("Successful test case 4");
    }

}
