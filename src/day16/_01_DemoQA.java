package day16;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import utils.BaseDriver;

import java.util.List;
import java.util.Random;

public class _01_DemoQA extends BaseDriver {

    private String username;
    private String password;

    @BeforeClass
    void goToWebsite() {
        username = "daulet";
        password = "DV@d9FjCm";
        driver.get("https://demoqa.com/books");
        driver.manage().window().maximize();
    }

    @Test(priority = 0)
    void loginTestCase() {
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("userName")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userName-value")));
        Assert.assertEquals(username,driver.findElement(By.cssSelector("#userName-value")).getText());
    }

    @Test(priority = 1)
    void addSingleToToCollectionTestCase(){
        List<WebElement> elements = driver.findElements(By.cssSelector(".mr-2"));
        WebElement randomElement = elements.get(new Random().nextInt(elements.size()));
        js.executeScript("arguments[0].scrollIntoView();", randomElement);
        randomElement.click();
        WebElement addBookButton = driver.findElement(By.cssSelector(".text-right #addNewRecordButton"));
        wait.until(ExpectedConditions.elementToBeClickable(addBookButton));
        js.executeScript("arguments[0].scrollIntoView();", addBookButton);
        addBookButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Book added to your collection.", alert.getText());
        alert.accept();
        removeAllBookFromCollection();
    }

    private void removeAllBookFromCollection() {
        driver.navigate().to("https://demoqa.com/profile");
        WebElement removeAllBooks = driver.findElement(By.cssSelector(".justify-content-end .text-right #submit"));
        wait.until(ExpectedConditions.elementToBeClickable(removeAllBooks));
        js.executeScript("arguments[0].scrollIntoView();", removeAllBooks);
        removeAllBooks.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("closeSmallModal-ok")));
        driver.findElement(By.id("closeSmallModal-ok")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("All Books deleted.", alert.getText());
        alert.accept();
    }

    @Test
    void addSeveralBookToCollectionTestCase(){
        // generate a random number up to number of books
        // add those books to collection
        // verify that the books you added are the same in the profile
        // delete all in the end
    }
}
