package day19;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _01_SimpleParameterTest  {

    @Parameters({"customerName"})
    @Test()
    void testCase1(String customerName) {
        System.out.println("The customer name is: " + customerName);
    }

}
