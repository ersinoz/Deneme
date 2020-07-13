package day16;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import utils.BaseDriver;

import java.util.ArrayList;
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

    @BeforeClass
    void loginTestCase() {
        driver.findElement(By.id("login")).click();
        driver.findElement(By.id("userName")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.id("login")).click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#userName-value")));
        Assert.assertEquals(username, driver.findElement(By.cssSelector("#userName-value")).getText());
    }

    @Test(priority = 0)
    void addSingleToToCollectionTestCase() {
        List<WebElement> elements = driver.findElements(By.cssSelector(".mr-2"));
        addBook(elements, new Random().nextInt(elements.size()));
        removeAllBookFromCollection();
    }



    @Test(priority = 1)
    void addSeveralBookToCollectionTestCase() {
        // generate a random number up to number of books
        List<WebElement> elements = driver.findElements(By.cssSelector(".mr-2"));
        int numberOfElementsToAdd = new Random().nextInt(elements.size()) + 1;
        System.out.println("Adding " + numberOfElementsToAdd + " elements!");
        // add those books to collection
        List<String> booksAdded = new ArrayList<>();
        for (int i = 0; i < numberOfElementsToAdd; i++) {
            booksAdded.add(addBook(elements, i));
            driver.navigate().back();
            wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".mr-2"), 0));
            elements = driver.findElements(By.cssSelector(".mr-2"));
        }

        // verify that the books you added are the same in the profile
        driver.navigate().to("https://demoqa.com/profile");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".mr-2"), 0));
        elements = driver.findElements(By.cssSelector(".mr-2"));
        for (WebElement element : elements) {
            Assert.assertTrue(booksAdded.contains(element.getText()), "The element: " + element.getText() + " is not in expected list " + booksAdded);
        }

        // delete all in the end
        removeAllBookFromCollection();

    }

    @Test
    void deleteASingleBookTestCase(){}

    @Test
    void searchForABookTestCase(){}

    @BeforeMethod
    void navigateToBooks() {
        driver.navigate().to("https://demoqa.com/books");
        wait.until(ExpectedConditions.numberOfElementsToBeMoreThan(By.cssSelector(".mr-2"), 0));
    }

    private void removeAllBookFromCollection() {
        driver.navigate().to("https://demoqa.com/profile");
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".justify-content-end .text-right #submit")));
        WebElement removeAllBooks = driver.findElement(By.cssSelector(".justify-content-end .text-right #submit"));
        js.executeScript("arguments[0].scrollIntoView();", removeAllBooks);
        removeAllBooks.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.id("closeSmallModal-ok")));
        driver.findElement(By.id("closeSmallModal-ok")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("All Books deleted.", alert.getText());
        alert.accept();
    }

    private String addBook(List<WebElement> elements, int index) {
        WebElement element = elements.get(index);
        js.executeScript("arguments[0].scrollIntoView();", element);
        element.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".text-right #addNewRecordButton")));

        WebElement addBookButton = driver.findElement(By.cssSelector(".text-right #addNewRecordButton"));
        js.executeScript("arguments[0].scrollIntoView();", addBookButton);
        addBookButton.click();
        wait.until(ExpectedConditions.alertIsPresent());
        Alert alert = driver.switchTo().alert();
        Assert.assertEquals("Book added to your collection.", alert.getText());
        alert.accept();

        return driver.findElement(By.cssSelector("#title-wrapper #userName-value")).getText();
    }
}
