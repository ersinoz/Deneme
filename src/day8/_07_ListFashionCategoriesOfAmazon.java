package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utils.BaseDriver;

public class _07_ListFashionCategoriesOfAmazon extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://amazon.com");
        Select categories = new Select(driver.findElement(By.id("searchDropdownBox")));
        for(WebElement category : categories.getOptions()) {
            if(category.getText().contains("Fashion")) {
                System.out.println(category.getText());
            }
        }
        driver.quit();
    }

}
