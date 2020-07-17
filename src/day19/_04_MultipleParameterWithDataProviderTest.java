package day19;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _04_MultipleParameterWithDataProviderTest {

    @Test(dataProvider = "credentialsProvider")
    void testCase1(String login, String password) {
        System.out.println("The login is: " + login);
        System.out.println("The password is: " + password);
    }

    @DataProvider(name = "credentialsProvider")
    public Object[][] data() {
        return new Object[][]{
                {"cedric", "password1"},
                {"anne", "password2"},
        };
    }

    @Test(dataProvider = "dataProvider")
    void testCase2(String name, Integer age) {
        System.out.println(name + " is " + age + " year old!");
    }

    @DataProvider(name = "dataProvider")
    public Object[][] data2() {
        return new Object[][]{
                {"cedric", 23},
                {"anne", 21},
        };
    }
}
