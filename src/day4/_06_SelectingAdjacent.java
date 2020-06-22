package day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utils.BaseDriver;

import java.util.List;

public class _06_SelectingAdjacent extends BaseDriver {
    public static void main(String[] args) throws InterruptedException {
        driver.get("https://formsmarts.com/form/yu?mode=h5");  // this will open the website and wait until full load

       // write me java code to print label of adjacent to #u_Uj7_4586_lbl
        WebElement adjacent = driver.findElement( By.cssSelector("#u_Uj7_4586_lbl + label") );
        System.out.println(adjacent.getText());

        // write me java code to print label second adjacent to #u_Uj7_4586_lbl
        WebElement nextAdjacent = driver.findElement( By.cssSelector("#u_Uj7_4586_lbl + label + label") );
        System.out.println(nextAdjacent.getText());
    }
}
