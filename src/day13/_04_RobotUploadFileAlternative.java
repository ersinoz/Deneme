package day13;

import org.openqa.selenium.By;
import utils.BaseDriver;

public class _04_RobotUploadFileAlternative extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://demo.guru99.com/test/upload/");

        String pathToFile = "C:\\Users\\User\\Desktop\\test.txt";;

        driver.findElement(By.cssSelector("input[type='file']")).sendKeys(pathToFile);

        driver.findElement(By.id("submitbutton")).click();
    }
}
