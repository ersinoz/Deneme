package day20;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import utils.BaseDriver;
import utils.ReusableMethods;

import java.util.List;

public class _01_OpenCartWithLoginTest extends OpenCartDriver {

    private String email;
    private String password;
    private boolean useRandom;
    // task1
    // make this credentials come from xml
    // if not supplied from xml, make sure to use default value
    // add additional boolean parameter, to use random generator or not, by default not
    @Parameters({"email", "password", "useRandom"})
    @BeforeClass(alwaysRun = true)
    void initCredentials(
            @Optional("test12345asda@test.com") String email,
            @Optional("someRassword123") String password,
            @Optional("false") String useRandom
    ) {
        if(useRandom.equals("true")){
            this.useRandom = true;
            this.email =  methods.randomWord(10) + "@test.com";
            this.password = methods.randomPassword(10);
        } else {
            this.useRandom = false;
            this.email = email;
            this.password = password;
        }
    }

    @Test(groups = "smoke", dependsOnMethods = "createAccountTest")
    void loginTestCase() {
        driver.navigate().to("https://opencart.abstracta.us/index.php?route=account/login");
        // test12345asd@test.com
        // qwerty12345

        //input the email
        driver.findElement(By.cssSelector("#input-email")).sendKeys(email);
        //input the password
        driver.findElement(By.cssSelector("#input-password")).sendKeys(password);
        //click on login
        driver.findElement(By.cssSelector("input[value=\"Login\"]")).click();
        //verify that you are logged in
        String title = driver.getTitle();
        Assert.assertEquals(title, "My Account");
    }

    @Test(alwaysRun = true)
    void createAccountTest() {
        if(this.useRandom) {
            driver.navigate().to("https://opencart.abstracta.us/index.php?route=account/register");

            driver.findElement(By.cssSelector("#input-firstname")).sendKeys("Name");
            driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Last Name");
            driver.findElement(By.cssSelector("#input-email")).sendKeys(email);
            driver.findElement(By.cssSelector("#input-telephone")).sendKeys("12345679812");
            driver.findElement(By.cssSelector("#input-address-1")).sendKeys("Last Name");
            driver.findElement(By.cssSelector("#input-city")).sendKeys("Last Name");
            driver.findElement(By.cssSelector("#input-postcode")).sendKeys("123123");
            Select country = new Select(driver.findElement(By.cssSelector("#input-country")));
            country.selectByIndex(3);
            WebDriverWait wait = new WebDriverWait(driver, 12);
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".fa-spin")));
            Select region = new Select(driver.findElement(By.cssSelector("#input-zone")));
            region.selectByIndex(2);
            driver.findElement(By.cssSelector("#input-password")).sendKeys(password);
            driver.findElement(By.cssSelector("#input-confirm")).sendKeys(password);
            driver.findElement(By.cssSelector("[name=\"agree\"]")).click();
            driver.findElement(By.cssSelector("[value=\"Continue\"]")).click();
            //verify that you are logged in
            String title = driver.getTitle();
            Assert.assertEquals(title, "Your Account Has Been Created!");

            driver.findElement(By.cssSelector("a.list-group-item[href*=logout]")).click();
        } else {
            // cannot throw skip exception here
            System.out.println("Using existing account");
        }
    }

    @Test(dependsOnMethods = {"loginTestCase"}, groups = {"functional"})
    void subscribeTestCase() {
        driver.findElement(By.cssSelector("a[href*=newsletter]")).click();
        driver.findElement(By.cssSelector("input[name=\"newsletter\"][value=\"1\"]")).click();
        driver.findElement(By.cssSelector("input[value=\"Continue\"]")).click();

        methods.verifyOneContainsText(driver.findElement(By.cssSelector(".alert-success")), "Success");
    }

    @Test(dependsOnMethods = {"loginTestCase"}, groups = {"functional"})
    void unSubscribeTestCase() {
        driver.findElement(By.cssSelector("a[href*=newsletter]")).click();
        driver.findElement(By.cssSelector("input[name=\"newsletter\"][value=\"0\"]")).click();
        driver.findElement(By.cssSelector("input[value=\"Continue\"]")).click();

        methods.verifyOneContainsText(driver.findElement(By.cssSelector(".alert-success")), "Success");
    }

    @Test(dependsOnMethods = {"loginTestCase"}, groups = {"functional"})
    void editAccountTestCase() {
        driver.findElement(By.cssSelector("a[href*=edit]")).click();

        methods.clearAndSendKeys(By.id("input-firstname"), "new first name");
        methods.clearAndSendKeys(By.id("input-lastname"), "new last name");

        driver.findElement(By.cssSelector("input[value=\"Continue\"]")).click();

        methods.verifyOneContainsText(driver.findElement(By.cssSelector(".alert-success")), "Success");
    }

    // task2
    // click on "Address book"
    // click on "New Address"
    // fill in the form
    // click on "Continue"
    // validate that new address was created
    @Test(dependsOnMethods = {"createAccountTest", "loginTestCase"})
    void editAddressBook(){
        driver.findElement(By.cssSelector("#column-right a[href*='account/address']")).click();
        wait.until(ExpectedConditions.titleIs("Address Book"));
        driver.findElement(By.cssSelector(".pull-right .btn-primary")).click();
        String firstName = "Ayse";
        driver.findElement(By.cssSelector("#input-firstname")).sendKeys(firstName);
        driver.findElement(By.cssSelector("#input-lastname")).sendKeys("Ayse");
        driver.findElement(By.cssSelector("#input-address-1")).sendKeys("1102 Slade");
        driver.findElement(By.cssSelector("#input-city")).sendKeys("Columbus");
        driver.findElement(By.cssSelector("#input-postcode")).sendKeys("42356");
        Select select= new Select(driver.findElement(By.id("input-country")));
        select.selectByIndex(2); // TODO: use random
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.cssSelector(".fa-spin")));
        Select select1= new Select(driver.findElement(By.id("input-zone")));
        select1.selectByIndex(2);  // TODO: use random
        driver.findElement(By.cssSelector(".pull-right .btn-primary")).click();
        Assert.assertEquals("Address Book Entries",driver.findElement(By.cssSelector("#content>h2")).getText());
        List<WebElement> elements = driver.findElements(By.cssSelector(".text-left"));
        methods.verifyAtLeastOneContainsText(elements, firstName);
    }

    // task3
    // edit the address
    // verify edition, by checking success message and verifyAtLeastOneContainsText()
}
