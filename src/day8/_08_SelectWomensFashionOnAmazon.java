package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.BaseStaticDriver;

public class _08_SelectWomensFashionOnAmazon extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://amazon.com");
        Select categories = new Select(driver.findElement(By.id("searchDropdownBox")));
        categories.selectByVisibleText("Women's Fashion");
//        driver.quit();
    }

}
