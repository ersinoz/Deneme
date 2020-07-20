package day20;

import org.openqa.selenium.By;
import org.testng.annotations.BeforeClass;
import utils.BaseDriver;
import utils.ReusableMethods;

public class OpenCartDriver extends BaseDriver {

    protected ReusableMethods methods;

    @BeforeClass(alwaysRun = true)
    void goToWebsite() {
        methods = new ReusableMethods(wait, driver, js);
        driver.get("https://opencart.abstracta.us/index.php");
        try {
            driver.findElement(By.id("details-button")).click();
            driver.findElement(By.id("proceed-link")).click();
        } catch (Exception e) {
            // this means there's no "Your connection is not private" page!
        }
    }
}
