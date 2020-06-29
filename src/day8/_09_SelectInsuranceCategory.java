package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.BaseDriver;

public class _09_SelectInsuranceCategory extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://www.iaai.com/");
        driver.findElement(By.id("js-keyword-filter")).click();

        Select categories = new Select(driver.findElement(By.id("VehiclesType")));
        categories.selectByIndex(0);
//        driver.quit();
    }

}
