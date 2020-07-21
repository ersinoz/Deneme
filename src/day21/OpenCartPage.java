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
}
