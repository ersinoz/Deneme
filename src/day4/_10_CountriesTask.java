package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

import java.util.List;

public class _10_CountriesTask extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://formsmarts.com/form/yu?mode=h5");  // this will open the website and wait until full load

        // find me all countries where country code doesn't start with the same letter as country name
        String cssSelector = "#section_2 > select:first-of-type > option";
        List<WebElement> listOfOptions = driver.findElements(By.cssSelector(cssSelector));
        for (WebElement option : listOfOptions) {
            char firstCharOfCountryCode = option.getAttribute("value").charAt(0);
            char firstCharOfCountryName = option.getText().charAt(0);
            if (firstCharOfCountryCode != firstCharOfCountryName) {
                System.out.println(option.getText());
            }
        }
    }
}
