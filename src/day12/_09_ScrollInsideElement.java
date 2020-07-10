package day12;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import utils.BaseStaticDriver;

public class _09_ScrollInsideElement extends BaseStaticDriver {

    public static void main(String[] args) throws InterruptedException {
        driver.get("http://ressio.github.io/lazy-load-xt/demo/horizontal.htm");
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement scrollArea =  driver.findElement(By.className("wrapper"));
        js.executeScript("arguments[0].scrollBy(1000,0)", scrollArea);

    }
}
