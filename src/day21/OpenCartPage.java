package day21;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class OpenCartPage {
    private WebDriver driver;

    public OpenCartPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(this.driver, this);
    }

    @FindBy(className = "fa-search")
    public WebElement searchButton;

    @FindBy(css = ".product-thumb h4")
    public List<WebElement> products;

    @FindBy(css = "a[href*=contact]")
    public WebElement contactUsLink;

    @FindBy(css = "textarea[name='enquiry']")
    public WebElement contactUsTextArea;

    @FindBy(css = "#content>p")
    public WebElement contactUsResult;

    @FindBy(id = "input-name")
    public WebElement nameInput;

    @FindBy(id = "input-email")
    public WebElement emailInput;

    @FindBy(css = "input[value='Submit']")
    public WebElement submitButton;


}
