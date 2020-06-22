package day4;

import org.openqa.selenium.By;
import utils.BaseDriver;

public class _05_SelectingByAttribute extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://formsmarts.com/form/yu?mode=h5");  // this will open the website and wait until full load

        // containing
        driver.findElement(By.cssSelector("#u_Uj7_4588")).click();
        driver.findElement(By.cssSelector("option[value*=Customer]")).click();

        // starting with
        driver.findElement(By.cssSelector("#u_Uj7_4597")).click();
        driver.findElement(By.cssSelector("option[value^=\"I\'m not using\"]")).click();

        // ends with
        driver.findElement(By.cssSelector("#u_Uj7_14598")).click();
        driver.findElement(By.cssSelector("option[value$=stan]")).click();


    }
}
