package day18;

import org.testng.annotations.*;

public class CommonClass {
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

    @BeforeTest
    void beforeTest() {
        System.out.println("Before Test!");
    }

    @AfterTest
    void afterTest() {
        System.out.println("After Test!");
    }

    @BeforeSuite
    void beforeSuite() {
        System.out.println("Before Suite!");
    }

    @AfterSuite
    void afterSuite() {
        System.out.println("After Suite!");
    }
}
