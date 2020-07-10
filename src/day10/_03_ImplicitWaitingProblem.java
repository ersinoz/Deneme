package day10;

import org.openqa.selenium.By;
import utils.BaseStaticDriver;

import java.util.concurrent.TimeUnit;

public class _03_ImplicitWaitingProblem extends BaseStaticDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        driver.findElement(By.cssSelector("#start > button")).click();
        // the element is present in html, but not visible
        // that's why this findElement will not wait for 5 seconds
        // and the text you get will be empty because the element is invisible
        String text = driver.findElement(By.id("finish")).getText();
        System.out.println(text);

        driver.quit();
    }

}
