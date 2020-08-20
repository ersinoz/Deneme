package StepFiles;

import POMFiles.LoginPage;
import Utils.Driver;
import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;

public class LoginSteps {
   LoginPage login = new LoginPage();

    @Given("^Navigate to Basqar: \"([^\"]*)\"$")
    public void navigate_to_Basqar(String url) {

     Driver.getDriver().get(url);
    }

    @When("^Enter the username \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void enter_the_username_and_password(String arg1, String arg2) {
        login.findElementAndSendKeys("userName",arg1);
        login.findElementAndSendKeys("password",arg2);





    }

    @When("^Click on loggin button$")
    public void click_on_loggin_button() {

    }

    @Then("^I am logged in successfully$")
    public void i_am_logged_in_successfully() {

    }

}
