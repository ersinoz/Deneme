package day18;

import org.testng.annotations.*;

public class CommonClass {
    @BeforeMethod(alwaysRun = true)
    void setup() {
        System.out.println("Before each method!");
    }

    @AfterMethod(alwaysRun = true)
    void cleanUp(){
        System.out.println("After each method!");
    }

    @BeforeClass(alwaysRun = true)
    void beforeClass() {
        System.out.println("Before class!");
    }

    @AfterClass(alwaysRun = true)
    void afterClass() {
        System.out.println("After Class!");
    }

    @BeforeTest(alwaysRun = true)
    void beforeTest() {
        System.out.println("Before Test!");
    }

    @AfterTest(alwaysRun = true)
    void afterTest() {
        System.out.println("After Test!");
    }

    @BeforeSuite(alwaysRun = true)
    void beforeSuite() {
        System.out.println("Before Suite!");
    }

    @AfterSuite(alwaysRun = true)
    void afterSuite() {
        System.out.println("After Suite!");
    }

    @BeforeGroups({"success"})
    void beforeSuccesGroup()
    {
        System.out.println("Before Success Group!");
    }
    @AfterGroups({"success"})
    void afterSuccesGroup()
    {
        System.out.println("After Success Group!");
    }

    @BeforeGroups({"fail"})
    void beforeFailGroup()
    {
        System.out.println("Before Fail Group!");
    }
    @AfterGroups({"fail"})
    void afterFailGroup()
    {
        System.out.println("After Fail Group!");
    }
}
