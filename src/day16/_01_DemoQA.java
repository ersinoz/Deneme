package day16;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseDriver;

public class _01_DemoQA extends BaseDriver {

    private String email;
    private String password;

    @BeforeClass
    void goToWebsite() {
        email = "test12345asda@test.com";
        password = "someRassword123";
        driver.get("https://demoqa.com/books");
    }

    @Test()
    void loginTestCase() {

    }

}
