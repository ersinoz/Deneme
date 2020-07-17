package day19;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _02_MultipleParameterTest {

    @Parameters({"login", "password"})
    @Test()
    void testCase1(String login, String password)
    {
        System.out.println("The login is: " + login);
        System.out.println("The password is: " + password);
    }

}
