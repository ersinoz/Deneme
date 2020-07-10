package day8;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.BaseDriver;

import java.util.List;
import java.util.Random;

public class _04_AddRemoveRandomNumberOfElementsTest extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
        // ------------------ create random buttons -----------------------
        WebElement button = driver.findElement(By.cssSelector("button[onclick='addElement()']"));
        Random rand = new Random();
        int count = rand.nextInt(20);
        for (int i = 0; i <count ; i++) {
            button.click();
        }
        List<WebElement> elementList1 = driver.findElements(By.cssSelector("button[class='added-manually']"));
        Thread.sleep(5000);
        System.out.println("Number of created buttons: "+elementList1.size());

        //------------------------------------- DELETE ---------------------------------------
        int count2 = rand.nextInt(count);
        for (int i = 0; i <count2 ; i++) {
            driver.findElement(By.cssSelector("button[class='added-manually']")).click();
        }
        List<WebElement> elementList2 = driver.findElements(By.cssSelector("button[class='added-manually']"));
        System.out.println("Number of remaining buttons: "+ elementList2.size());
        System.out.println("Number of buttons before deleting: " +elementList1.size());
        Assert.assertEquals((count-count2), elementList2.size());
        driver.quit();
    }

}
