package day7;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import utils.BaseDriver;

import java.util.concurrent.TimeUnit;

public class _02_WindowSize extends BaseDriver {
    public static void main(String[] args) {
        driver.get("https://www.seleniumeasy.com/test/javascript-alert-box-demo.html");
        Dimension dimension = driver.manage().window().getSize();
        System.out.println(dimension.height);
        System.out.println(dimension.width);

        Dimension changedDimension = new Dimension(500, 500); // new size for window, for example to test mobile version of the website

        driver.manage().window().setSize(changedDimension);
    }

}
