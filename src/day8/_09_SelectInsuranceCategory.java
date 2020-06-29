package day8;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import utils.BaseDriver;

import java.util.concurrent.TimeUnit;

public class _09_SelectInsuranceCategory extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.iaai.com/");
        driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
        driver.findElement(By.id("js-keyword-filter")).click();
        Select categories = new Select(driver.findElement(By.id("VehiclesType")));
        categories.selectByIndex(0);
//        driver.quit();
    }

}
