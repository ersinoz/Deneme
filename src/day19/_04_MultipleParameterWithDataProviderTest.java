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


}
