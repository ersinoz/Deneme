package POMFiles;

import Utils.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends Parent {
    WebElement myElement;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(css = "[formcontrolname=username]")
    private WebElement userName;
    @FindBy(css = "[formcontrolname=password]")
    private WebElement password;
    @FindBy(css = "[aria-label=LOGIN]")
    private WebElement loginButton;

    public void findElementAndClick(String element) {
        switch (element) {
            case "loginButton":
                myElement = loginButton;
                break;

        }

        waitAndClick(myElement);
    }

    public void findElementAndSendKeys(String element,String text) {
        switch (element) {
            case "userName":
                myElement = userName;
                break;
            case "password":
                myElement = password;
                break;
        }
        waitAndSendKeys(myElement,text);
    }
}
