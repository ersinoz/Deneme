package day8;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BaseStaticDriver;

import java.util.List;
import java.util.Random;

public class _03_AddRandomNumberOfElementsTest extends BaseStaticDriver {
    public static void main(String[] args) {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        WebElement button = driver.findElement(By.cssSelector("button[onclick='addElement()']"));

        Random rand = new Random();
        int count = rand.nextInt(10);
        for (int i = 0; i < count; i++) {
            button.click();
        }
        List<WebElement> elementList = driver.findElements(By.cssSelector("button[class='added-manually']"));
        Assert.assertEquals(count, elementList.size());

    }

}
