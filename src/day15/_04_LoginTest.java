package day15;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseDriver;

public class _04_LoginTest extends BaseDriver {

    @BeforeClass
    void goToWebsite() {
        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
    }

    @Test
    void loginTestCase() {
            // test12345asd@test.com
            // qwerty12345

    }


}
